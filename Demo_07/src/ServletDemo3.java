import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 转发
 */
@WebServlet(name = "ServletDemo3", urlPatterns = {"/Demo3"})
public class ServletDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String str = "sxz";

        System.out.println("A:我想办事");
        System.out.println("B:我办不了，但我可以找人帮你");
        //将请求转发到Demo4
        //将非表单的数据添加到request的域中
        request.setAttribute("s",str);
        request.getRequestDispatcher("/Demo4").forward(request,response);
        System.out.println("B：事情办完了");
    }
}
