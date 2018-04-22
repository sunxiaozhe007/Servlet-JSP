package ServletDemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FilePermission;
import java.io.IOException;
import java.util.Properties;

@WebServlet(name = "ServletDemo4",urlPatterns = {"/Demo4"})
public class ServletDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = this.getServletContext().getRealPath("/WEB-INF/a.properties");
        System.out.println(path);
        Properties pro = new Properties();
        pro.load(new FileInputStream(path));
        System.out.println(pro.getProperty("key"));

    }
}
