package org.news.test;

import org.news.util.ConfigManager;

public class TestConfigManager {
    public static void main(String[] args) {
        String driver= ConfigManager.getProperty("driver");//获取驱动类
        String url=ConfigManager.getProperty("url");//获取连接mysql
        String user=ConfigManager.getProperty("user");//获取数据库的用户名
        String password=ConfigManager.getProperty("password");//
        System.out.println(driver);
        System.out.println(url);
        System.out.println(user);
        System.out.println(password);
    }
}