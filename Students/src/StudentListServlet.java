import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentListServlet" , urlPatterns = {"/list"})
public class StudentListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //调用业务逻辑
        StudentServiceImpl studentService = new StudentServiceImpl();
        List<Student> list = studentService.findAllStudent();

        if (list!=null){
            //把list放入reqeust对象中
            request.setAttribute("student",list);
            //跳转页面
            request.getRequestDispatcher("list.jsp").forward(request,response);
        }
    }
}
