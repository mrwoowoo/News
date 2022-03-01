package org.news.test;

import org.junit.Test;
import org.news.entity.Topic;
import org.news.service.TopicService;
import org.news.service.impl.TopicServiceImpl;

import java.sql.SQLException;
import java.util.List;

//测试类
public class TestTopicServiceImpl {
    @Test
    public void testFindAllTopics() throws SQLException {
        //创建TopicService
        TopicService topicService = new TopicServiceImpl();
        //调用查询方法
        List<Topic> list = topicService.findAllTopics();
        //遍历集合主题
        for (Topic topic:list) {
            System.out.println(topic);
        }
    }
}
