package org.news.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
    private static Properties properties=null;
    //静态代码块可以最快加载读取到的
    static{
        InputStream is=ConfigManager.class.getClassLoader().getResourceAsStream("database.properties");
        if(is==null){
            throw  new RuntimeException("找不到数据库配置文件");
        }
        //创建Properties对象
        properties = new Properties();

        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            //关闭字节输入流
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    //读取配置属性键和值，通过键得到相对应的字符串值
    public static String getProperty(String key){//driver
        return properties.getProperty(key);//com.mysql.jdbc.Driver
    }
}