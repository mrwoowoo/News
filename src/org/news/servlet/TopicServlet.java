package org.news.servlet;

import org.news.entity.Topic;
import org.news.service.TopicService;
import org.news.service.impl.TopicServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
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
        PrintWriter out = response.getWriter();
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
        }else if (opr.equals("add")) { //添加主题
            //获取提交的主题名称
            String tname = request.getParameter("tname");
            String status; //状态
            String message; //提示
            //处理，返回前端
            try {
                int result = topicService.addTopic(tname);
                if (result == -1) { //数据库有这个主题，提示输入其他主题
                    status = "exist";
                    message = "已经存在相同的主题了，请输入其他的主题名称！";
                }else { //数据库没有这个主题，可以添加
                    status = "success";
                    message = "添加主题成功！！";
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                status = "error";
                message = "添加失败！！";
            }
            out.print("[{\"status\":\""+status+"\",\"message\":\""+message+"\"}]");
        }
    }
}
