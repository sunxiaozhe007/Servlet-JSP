package servletConfig;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletCongigDemo")
public class ServletCongigDemo extends HttpServlet {

   /* private ServletConfig config;

    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }*/

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//       String encoding = config.getInitParameter("encoding");//获取配置文件信息
//       System.out.println(encoding);
    //第二种方法
       /* String encoding = super.getInitParameter("encoding");
        System.out.println(encoding);*/
       //第三种方法
        String encoding = this.getServletConfig().getInitParameter("encoding");
        System.out.println(encoding);
    }
}
