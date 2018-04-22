import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * 图片下载
 */
@WebServlet(name = "ServletDemo3" , urlPatterns = {"/Demo3"})
public class ServletDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //同过路径得到一个输入流
        String path = this.getServletContext().getRealPath("/WEB-INF/classes/sxz.jpg");
        FileInputStream fis = new FileInputStream(path);
        //创建字节输出流
        ServletOutputStream sos = response.getOutputStream();
        //得到要下载的文件名
        String filename = path.substring(path.lastIndexOf("\\")+1);
        //设置文件名的编码
        filename = URLEncoder.encode(filename , "UTF-8");
        //告知客户端下载文件
        response.setHeader("content-disposition" , "attachment; filename="+filename);
        response.setHeader("content-type", "image/jpeg");
        //执行输出操作
        int len = 1;
        byte[] b = new byte[1024];
        while((len=fis.read(b))!=-1){
            sos.write(b , 0 , len);
        }

        sos.close();
        fis.close();
    }
}
