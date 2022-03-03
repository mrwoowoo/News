package org.news.service.impl;

import org.news.dao.TopicDao;
import org.news.dao.impl.TopicDaoImpl;
import org.news.entity.Topic;
import org.news.service.TopicService;
import org.news.util.DataBaseUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

//主题实现类
public class TopicServiceImpl implements TopicService {

    //获取所以主题
    @Override
    public List<Topic> findAllTopics() throws SQLException {
        Connection connection = null;

        try {
            connection = DataBaseUtil.getConnection();
            TopicDao topicDao = new TopicDaoImpl(connection);
            List<Topic> list = topicDao.getAllTopics();
//            return new TopicDaoImpl(connection).getAllTopics();
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw throwables;
        } finally {
            DataBaseUtil.closeAll(connection, null, null);
        }
    }

    @Override
    public int addTopic(String name) throws SQLException {
        Connection connection = null;
        int result = 0;
        try {
            connection = DataBaseUtil.getConnection();
            connection.setAutoCommit(false); //关闭自动提交
            //依赖上一层Dao
            TopicDao topicDao = new TopicDaoImpl(connection);
            if(topicDao.findTopicByName(name) == null) { //没有主题添加
                result = topicDao.addTopic(name);
            }else {
                result = -1;
            }
            connection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            if(connection != null) {
                try {
                    connection.rollback(); //事务回滚
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }finally {
            DataBaseUtil.closeAll(connection, null, null);
        }
        return result;
    }
}
