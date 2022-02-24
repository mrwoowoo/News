package org.news.dao;

import org.news.entity.User;

import java.sql.SQLException;

//用户接口类
public interface UserDao {
    //查询用户名和密码是否登录成功
    public User findUser(String uname, String upwd) throws SQLException;
}
