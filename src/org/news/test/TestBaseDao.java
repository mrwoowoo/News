package org.news.test;

import org.news.dao.BaseDao;
import org.news.util.DataBaseUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestBaseDao {
    public static void main(String[] args) throws SQLException {
        Connection connection= DataBaseUtil.getConnection();
        BaseDao baseDao=new BaseDao(connection);
        //调用增删改的方法,并且返回执行结果
//        int result = baseDao.executeUpdate("insert into news_users(uname,upwd)values(?,?)","张三","123456");
//        System.out.println(result>0?"添加成功":"添加失败");
//        result = baseDao.executeUpdate("")
        Statement st = connection.createStatement();
        st.executeQuery("SELECT * FROM news_users");
        ResultSet rs = st.getResultSet();
        while (rs.next())
        {
            System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
        }
        
    }
}