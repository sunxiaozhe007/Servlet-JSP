import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletDemo1" , urlPatterns = {"/Demo1"})
public class ServletDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     /* response.setCharacterEncoding("UTF-8");//告知服务器使用UTF-8解析文本
        response.setHeader("content-type","text/html");//告诉浏览器用什么编码解析*/
       response.setContentType("text/html;charset=UTF-8");//告诉浏览器和服务器应使用什么编码
       PrintWriter out = response.getWriter();//字符输出流
         out.write("孙晓哲！");//向客户端响应文本内容

    }
}
