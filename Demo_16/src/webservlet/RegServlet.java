package webservlet;

import domain.User;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(name = "Servlet",urlPatterns = {"/reg"})

public class RegServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF8");
        //获取表单数据
        User user = new User();

        response.getWriter().write("注册成功，1秒后跳转到主页");
        response.setHeader("refresh","1;url="+request.getContextPath()+"/index.jsp");
    }
    }

