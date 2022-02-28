package org.news.servlet;

import org.news.entity.News;
import org.news.service.NewsService;
import org.news.service.impl.NewsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class NewsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //获取请求参数
        String opr = request.getParameter("opr");
        //创建Service层
        NewsService newsService = new NewsServiceImpl();
        try {
            if("listHtml".equals(opr)) { //查询所以新闻数据
                List<News> list = newsService.findAllNews(); //调用查询所以新闻方法，返回List
                request.setAttribute("list",list);//保存Request对象
                //跳转showNews.jsp,把数据展示到这个页面
                request.getRequestDispatcher("/newspages/showNews.jsp").forward(request, response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
