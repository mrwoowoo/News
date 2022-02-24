package org.news.dao;

import org.news.util.DataBaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 统一的增删改查
 *
 *
 *
 *  **/

public class BaseDao {
    //连接对象在构造方法进行传入
    private Connection connection;
    int i;

    public BaseDao(Connection connection) {
        this.connection = connection;
    }

    //增删改,影响你的表的记录行数,1 int类型,SQL语句,占位符insert into user values
    public int executeUpdate(String sql, Object... params) throws SQLException {
        int res = 0;
        PreparedStatement ps = null;
        //通过连接对象获取执行SQL语句的对象
        try {
            ps = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
            //执行SQL语句
            res = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DataBaseUtil.closeAll(null, ps, null);
        }
        return res;

    }

    //查询操作
    public ResultSet executeQuery(String sql, Object... params) throws SQLException {
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try {
            //获取sql对象
            pstmt = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            //执行
            rs = pstmt.executeQuery();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw throwables;
        }
        return rs;
    }
}

