package Servlet;

import domain.User;
import service.UserService;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AutoLoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //1.转换两个对象HttpServletRequest，HttpServletResponse
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String uri = req.getRequestURI();
       // System.out.println(uri);
        String path = req.getContextPath();
       // System.out.println(path);
        path = uri.substring(path.length()+1);
        //System.out.println(path);

        if (!("/login.jsp".equals(path)||"/LoginServlet".equals(path))){
            //2.处理业务
            //得到cookie
            Cookie[] cookies = req.getCookies();
            String username = "";
            String userpwd = "";
            //从数组中找到想要的User对象信息
            for (int i = 0; cookies!=null && i < cookies.length;i++){
                if ("user".equals(cookies[i].getName())){
                    String value = cookies[i].getValue();
                    String[] values = value.split("&");
                    username = values[0];
                    userpwd = values[1];

                }
            }

            //登录操作
            UserService us = new UserService();
            try {
                User user =  us.findUser(username,userpwd);
                //如果登陆成功把用户信息存到session中
                if (user!=null){
                    req.getSession().setAttribute("user",user);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //3。放行
            filterChain.doFilter(servletRequest, servletResponse);
        }


    }

    @Override
    public void destroy() {

    }
}
