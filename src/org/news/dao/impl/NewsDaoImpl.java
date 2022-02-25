package org.news.dao.impl;

import org.news.dao.BaseDao;
import org.news.dao.NewsDao;
import org.news.entity.News;
import org.news.util.DataBaseUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsDaoImpl extends BaseDao implements NewsDao {

    public NewsDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public List<News> getAllNews() throws SQLException {
        List<News> list = new ArrayList<News>();
        String sql = "select nid, ntid, ntitle, nauthor, ncreateDate, nsummary, tname " +
                "from news, topic where news.ntid=topic.tid " +
                "order by ncreateDate desc";
        ResultSet rs = null;
        try {
            //调用查询方法
            rs = this.executeQuery(sql);
            News news = null;
            //遍历取出新闻记录保存
            while (rs.next()) {
                news = new News();
                news.setNid(rs.getInt("nid"));
                news.setNtid(rs.getInt("ntid"));
                news.setNtitle(rs.getString("ntitle"));
                news.setNauthor(rs.getString("nauthor"));
                news.setNcreateDate(rs.getTimestamp("ncreateDate"));
                news.setNsummary(rs.getString("nsummary"));
                news.setTname(rs.getString("tname"));
                list.add(news);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DataBaseUtil.closeAll(null, null, rs);
        }
        return list;
    }
}
