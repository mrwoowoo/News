package org.news.test;

import org.news.dao.impl.NewsDaoImpl;
import org.news.entity.News;
import org.news.util.DataBaseUtil;

import java.sql.SQLException;
import java.util.List;

public class TestNewsDaoImpl {
    public static void main(String[] args) throws SQLException {
        //创建NewsDaoImpl实现类
        NewsDaoImpl newsDao = new NewsDaoImpl(DataBaseUtil.getConnection());
        //条约查询方法
        List<News> newsList = newsDao.getAllNews();
        for (News news: newsList) {
            System.out.println(news);
        }
    }
}
