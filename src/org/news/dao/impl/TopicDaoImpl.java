package org.news.dao.impl;

import org.news.dao.BaseDao;
import org.news.dao.TopicDao;
import org.news.entity.Topic;
import org.news.util.DataBaseUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TopicDaoImpl extends BaseDao implements TopicDao {

    public TopicDaoImpl(Connection connection) {
        super(connection);
    }
    //获取所以主题
    @Override
    public List<Topic> getAllTopics() throws SQLException {
        List<Topic> list = new ArrayList<Topic>();
        ResultSet rs = null;
        String sql="select * from topic";
        try {
            rs = executeQuery(sql);
            Topic topic = null;
            while (rs.next()) {
                topic = new Topic();
                topic.setTid(rs.getInt("tid"));
                topic.setTname(rs.getString("tname"));
                list.add(topic);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw throwables;
        } finally {
            DataBaseUtil.closeAll(null, null, rs);
        }
        return list;
    }

    //添加主题
    @Override
    public int addTopic(String name) throws SQLException {
        String sql = "insert into topic(tname) values(?)";
        int result = this.executeUpdate(sql, name);
        return result;
    }
}
