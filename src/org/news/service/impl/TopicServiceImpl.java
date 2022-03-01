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
}
