package org.news.service.impl;

import org.news.dao.impl.UserDaoImpl;
import org.news.entity.User;
import org.news.service.UserService;
import org.news.util.DataBaseUtil;

import java.sql.Connection;
import java.sql.SQLException;

//UserService接口实现类
public class UserServiceImpl implements UserService {

    //完成登录的功能操作
    @Override
    public User doLogin(User user) throws SQLException {
        //创建UserDaoImpl
        Connection connection = null;
        try {
            //获取连接
            connection = DataBaseUtil.getConnection();
            //创建UserDao
            UserDaoImpl userDao = new UserDaoImpl(connection);
            User u =userDao.findUser(user.getUname(), user.getUpwd());
            return u;
        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }finally {
            DataBaseUtil.closeAll(connection, null, null);
        }
    }
}
