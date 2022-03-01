package org.news.servlet;

import org.news.entity.Topic;
import org.news.service.TopicService;
import org.news.service.impl.TopicServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class TopicServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //获取前端请求参数
        String opr = request.getParameter("opr");
        //创建业务层对象
        TopicService topicService = new TopicServiceImpl();
        if(opr.equals("listHtml")) {//查询使用主题
            List<Topic> list = null;
            try {
                //查询所有主题方法
                list = topicService.findAllTopics();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            //把查询对象保存至Request对象
            request.setAttribute("list", list);
            request.getRequestDispatcher("/newspages/showTopics.jsp").forward(request, response);
        }
    }
}
