import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletDemo3", urlPatterns = {"/Demo3"})
public class ServletDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //获取表单数据
        String userName = request.getParameter("userName");
        String pwd = request.getParameter("pwd");
        String  code = request.getParameter("code");
        //处理业务逻辑
        String scode;
        scode = (String) request.getSession().getAttribute("scode");
        if ("sun".equals(userName)&&"123".equals(pwd)){
            if (!code.equals(scode)){
                String msg = "验证码错误";
                request.setAttribute("msg",msg);
                request.getRequestDispatcher("/index.jsp").forward(request,response);

            }
            out.println("登陆成功！");
        }

    }
}
