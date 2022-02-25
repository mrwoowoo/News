package org.news.service.impl;

import org.news.dao.NewsDao;
import org.news.dao.impl.NewsDaoImpl;
import org.news.entity.News;
import org.news.service.NewsService;
import org.news.util.DataBaseUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

//业务层
//新闻业务实现类

public class NewsServiceImpl implements NewsService {
//    获取所以新闻数据
    @Override
    public List<News> findAllNews() throws SQLException {
        //获取连接对象
        Connection connection = null;
        List<News> newsList = null;
        try {
            connection = DataBaseUtil.getConnection();
            //创建MewDaoImpl
            NewsDao newsDao = new NewsDaoImpl(connection);
            //调用查询所以
            newsList = newsDao.getAllNews();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw throwables;
        } finally {
            DataBaseUtil.closeAll(connection,null,null);
        }
        return newsList;
    }
//    @Override
//    public List<News> findAllNews() throws SQLException {
//        return new NewsDaoImpl(DataBaseUtil.getConnection()).getAllNews();;
//    }
}
