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

    //添加主题
    @Test
    public void testAddTopic() throws SQLException {
        TopicService topicService = new TopicServiceImpl();
        int result = topicService.addTopic("其他");
        System.out.println(result>0?"添加主题成功":"添加主题失败");
    }
}
