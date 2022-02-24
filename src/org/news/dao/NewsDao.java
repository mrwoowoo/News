package org.news.dao;


import org.news.entity.News;

import java.sql.SQLException;
import java.util.List;

//新闻接口
public interface NewsDao {
    //查询获取所以新闻
    public List<News> getAllNews() throws SQLException;
}
