package org.news.dao;

import org.news.entity.Topic;

import java.sql.SQLException;
import java.util.List;

//主题接口类
public interface TopicDao {
    //获取所以主题
    public List<Topic> getAllTopics() throws SQLException;

    //添加主题，添加主题名称,添加SQL语句，奇闻
    public int addTopic(String name) throws SQLException;

    //依据主题名称查找主题
    public Topic findTopicByName(String name) throws SQLException;
}
