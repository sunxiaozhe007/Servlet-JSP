import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletDologin" , urlPatterns = {"/dologin"})
public class ServletDologin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取表单数据
        String userName = request.getParameter("userName");
        String pwd = request.getParameter("pwd");
        //处理业务逻辑
        if ("sun".equals(userName)&&"123".equals(pwd)){
            request.getSession().setAttribute("name" , userName);
            //一次转发
            request.getRequestDispatcher("/success.jsp").forward(request,response);
            //response.sendRedirect(request.getContextPath()+"success.jsp");
        }else{
            //response.sendRedirect(request.getContextPath()+"login.jsp");
            request.setAttribute("msg", "密码不正确");
            request.getRequestDispatcher("/login.jsp").forward(request,response);

        }
    }
}
