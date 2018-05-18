import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DownloadServlet",urlPatterns = {"/down"})
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置一个要下载的文件
        String filename = "sxz.csv";

        filename = new String(filename.getBytes("UTF-8"),"iso-8859-1");
        //告知浏览器下载文件
        response.setHeader("content-disposition","attachment;filename="+filename);
        response.setContentType(this.getServletContext().getMimeType(filename));//根据文件名自动获得文件类型

        //告知服务器使用什么编码读文件
        response.setCharacterEncoding("UTF-8");

        //创建一个文件输出流
        PrintWriter out = response.getWriter();
        out.write("电视机,20\n");
        out.write("洗衣机,20\n");
        out.write("冰箱,20\n");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
