package org.news.service;

import org.news.entity.Topic;

import java.sql.SQLException;
import java.util.List;

public interface TopicService {
    //获取所以主题
    public List<Topic> findAllTopics() throws SQLException;
}
