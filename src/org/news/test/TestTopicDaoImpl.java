package org.news.test;

import org.junit.Test;
import org.news.dao.TopicDao;
import org.news.dao.impl.TopicDaoImpl;
import org.news.entity.Topic;
import org.news.service.impl.TopicServiceImpl;
import org.news.util.DataBaseUtil;

import java.sql.SQLException;
import java.util.List;

public class TestTopicDaoImpl {
    @Test
    public void testTestTopicDaoImpl() throws SQLException {
        TopicDao topicDao = new TopicDaoImpl(DataBaseUtil.getConnection());
        List<Topic> list = topicDao.getAllTopics();
        for (Topic topic : list) {
            System.out.println(topic);
        }
    }

    @Test
    public void testAddTopic() throws SQLException {
        TopicDao topicDao = new TopicDaoImpl(DataBaseUtil.getConnection());
        int result = topicDao.addTopic("奇闻");
        System.out.println(result>0?"添加成功":"添加失败");
    }
}
