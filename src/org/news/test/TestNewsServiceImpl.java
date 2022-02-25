package org.news.test;

import org.news.entity.News;
import org.news.service.impl.NewsServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class TestNewsServiceImpl {
    public static void main(String[] args) throws SQLException {
        //创建NewsServiceImpl
        NewsServiceImpl newsService = new NewsServiceImpl();
        //调用查询方法
        List<News> newsList = newsService.findAllNews();
        for (News news: newsList) {
            System.out.println(news);
        }
    }
}
