package org.news.test;

import org.news.dao.impl.UserDaoImpl;
import org.news.entity.User;
import org.news.util.DataBaseUtil;

import java.sql.SQLException;

public class TestUserDaoImpl {
    public static void main(String[] args) throws SQLException {
        //创建用户实现类
        UserDaoImpl userDao = new UserDaoImpl((DataBaseUtil.getConnection()));
        //调用查询用户方法
        User user = userDao.findUser("admin","admin");
        //获取User类的用户名和密码
        System.out.println(user.getUid()+"|"+user.getUname()+"|"+user.getUpwd());
    }
}
