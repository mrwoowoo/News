package org.news.dao.impl;

import org.news.dao.BaseDao;
import org.news.dao.NewsDao;
import org.news.entity.News;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class NewsDaoImpl extends BaseDao implements NewsDao {

    public NewsDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public List<News> getAllNews() throws SQLException {
        return null;
    }
}
