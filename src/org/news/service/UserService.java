package org.news.service;

import org.news.entity.User;

import java.sql.SQLException;

//用户接口类
public interface UserService {
    //用户登录操作
    public User doLogin(User user) throws SQLException;
}
