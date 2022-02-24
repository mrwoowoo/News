package org.news.test;

import org.news.entity.User;
import org.news.service.impl.UserServiceImpl;

import java.sql.SQLException;

public class TestUserServiceImpl {
    public static void main(String[] args) throws SQLException {
        //创建UserServiceImpl
        UserServiceImpl userService = new UserServiceImpl();
        User user = new User();
        user.setUname("admin");
        user.setUpwd("admin");
        //调用查询登录方法
        User u = userService.doLogin(user);
        System.out.println(u);
    }
}
