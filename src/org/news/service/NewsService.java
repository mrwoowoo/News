package org.news.service;

import org.news.entity.News;

import java.sql.SQLException;
import java.util.List;

//业务层
public interface NewsService {
    //获取所以新闻
    public List<News> findAllNews() throws SQLException;
}
