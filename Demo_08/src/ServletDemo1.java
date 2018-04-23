import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletDemo1",urlPatterns = {"/Demo1"})
public class ServletDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getMethod());//GET
        System.out.println(request.getRequestURL());//http://localhost:8080/Demo1
        System.out.println(request.getRequestURI());///Demo1
        System.out.println(request.getContextPath());//当前应用的虚拟目录
        System.out.println(request.getQueryString());//返回请求行参数


    }
}
