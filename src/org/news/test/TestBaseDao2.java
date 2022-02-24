package org.news.test;

import org.news.dao.BaseDao;
import org.news.util.DataBaseUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestBaseDao2 {
    public static void main(String[] args) throws SQLException {
        //创建连接对象
        Connection connection = DataBaseUtil.getConnection();
        //创建BaseDao
        BaseDao baseDao = new BaseDao(connection);
        //调用查询方法，传入SQL语句
        ResultSet rs = baseDao.executeQuery("select * from news_users where uname=? and upwd=?", "admin", "admin");
        while (rs.next()) {
            int uid = rs.getInt("uid");
            String uname = rs.getString("uname");
            String upwd = rs.getString("upwd");
            System.out.println(uid + "," + uname + "," + upwd);
        }
    }
}
