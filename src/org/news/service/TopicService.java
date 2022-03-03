package org.news.service;

import org.news.entity.Topic;

import java.sql.SQLException;
import java.util.List;

public interface TopicService {
    //获取所以主题
    public List<Topic> findAllTopics() throws SQLException;

    //添加主题
    public int addTopic(String name) throws SQLException;
}
