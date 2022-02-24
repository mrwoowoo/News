package org.news.util;



import java.sql.*;

public class DataBaseUtil {
    private  static String driver= ConfigManager.getProperty("driver");
    private  static String url= ConfigManager.getProperty("url");
    private  static String user= ConfigManager.getProperty("user");
    private  static String password= ConfigManager.getProperty("password");
    //加载驱动管理器
    static{
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
    //获取数据库连接对象
    public  static Connection getConnection(){
        Connection connection =null;
        try {
            connection =  DriverManager.getConnection(url,user,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;//返回连接对象

    }
    //统一关闭
    public static  void closeAll(Connection connection, Statement statement, ResultSet resultSet) throws SQLException {
        //如果结果集对象不为空，就关闭
        if(resultSet!=null&&resultSet.isClosed()){
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


        if(statement!=null){
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

}