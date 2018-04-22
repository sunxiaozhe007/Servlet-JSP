import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletDemo2" , urlPatterns = {"/Demo2"})
public class ServletDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        ServletInputStream sis = request.getInputStream();
        int len = 0;
        byte[] b = new byte[1024];
        while((len= sis.read(b))!=-1){
            System.out.println(new String(b , 0, len , "UTF-8"));
        }
        sis.close();
    }
}
