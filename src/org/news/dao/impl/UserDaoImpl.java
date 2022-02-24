package org.news.dao.impl;

import org.news.dao.BaseDao;
import org.news.dao.UserDao;
import org.news.entity.User;
import org.news.util.DataBaseUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

//用户实现类
public class UserDaoImpl extends BaseDao implements UserDao {

    public UserDaoImpl(Connection connection) {
        super(connection);
    }

    //完成查询用户操作
    @Override
    public User findUser(String uname, String upwd) throws SQLException {
        String sql = "select * from news_users where uname=? and upwd=?";
        ResultSet rs = null;
        User user = null;
        try {
            rs = this.executeQuery(sql, uname, upwd);
            user = new User();
            if (rs.next()) {
                int id = rs.getInt("uid");
                user.setUid(id);
                user.setUname(uname);
                user.setUpwd(upwd);
                return user;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DataBaseUtil.closeAll(null, null, rs);
        }
        return null;
    }
}
