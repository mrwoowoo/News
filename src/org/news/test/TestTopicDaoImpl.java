package org.news.test;

import org.junit.Test;
import org.news.dao.impl.TopicDaoImpl;
import org.news.entity.Topic;
import org.news.util.DataBaseUtil;

import java.sql.SQLException;
import java.util.List;

public class TestTopicDaoImpl {
    @Test
    public void testTestTopicDaoImpl() throws SQLException {
        TopicDaoImpl topicDao =new TopicDaoImpl(DataBaseUtil.getConnection());
        List<Topic> list = topicDao.getAllTopics();
        for (Topic topic : list) {
            System.out.println(topic);
        }
    }
}
