package org.news.servlet;

import org.news.entity.User;
import org.news.service.UserService;
import org.news.service.impl.UserServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;

public class UserServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        this.doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        //获取响应流
        PrintWriter out = response.getWriter();
        String opr = request.getParameter("opr");
        String contextPath = request.getContextPath();
        UserService userService = new UserServiceImpl();
        try {
            if("login".equals(opr)) {
                String uname = request.getParameter("uname");
                String upwd = request.getParameter("upwd");
                User user = new User();
                user.setUname(uname);
                user.setUpwd(upwd);
                user = userService.doLogin(user);
                if(user == null) {
                    out.print("<script type=\"text/javascript\">");
                    out.print("alert(\"用户名密码错误，请重新登录\");");
                    out.print("open(\""+contextPath+"/index.jsp\",\"_self\");");
                    out.print("</script>");
                }else{
                    request.getSession().setAttribute("admin", uname);
                    response.sendRedirect(contextPath+"/newspages/admin.jsp");
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        out.flush();
        out.close();
    }
}
