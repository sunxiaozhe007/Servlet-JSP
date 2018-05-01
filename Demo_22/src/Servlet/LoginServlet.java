package Servlet;

import domain.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet",urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String userpwd = request.getParameter("userpwd");

        UserService us = new UserService();
        try {
            User user = us.findUser(username,userpwd);

        if (user!=null){
            String autologin = request.getParameter("autologin");
            Cookie cookie = new Cookie("user",user.getUsername()+"&"+user.getUserpwd());
            cookie.setPath("/");
            if (autologin!=null){//把用户信息保存到cookie中
                cookie.setMaxAge(60*60*24*30);
            }else{//清除cookie对象的的数据
                cookie.setMaxAge(0);
            }
            response.addCookie(cookie);//把cookie保存到客户端
            request.getSession().setAttribute("user",user);
            request.getRequestDispatcher("/home.jsp").forward(request,response);
        }else{
            request.setAttribute("msg","用户名或密码错误，请重新登陆");
            request.getRequestDispatcher("/login.jsp").forward(request,response);

        }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
