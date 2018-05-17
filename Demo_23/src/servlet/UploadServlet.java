package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "UploadServlet",urlPatterns = {"/upload"})
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*表单中提交数据的方式改为multipart/form-data 所以request.getParameter失效
        String name = request.getParameter("name");
        String photo = request.getParameter("photo");
        System.out.println(name);
        System.out.println(photo);*/

        InputStream inputStream = request.getInputStream();
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len=inputStream.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }
        inputStream.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
