import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "ServletDemo1",urlPatterns = {"/Demo1"})
public class ServletDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html；charset=UTF-8");
        PrintWriter out = response.getWriter();
        //获取客户端保存的最后访问时间
        Cookie[] cookies = request.getCookies();//获得客户端所有cookie对象
        for (int i = 0; cookies!=null&&i<cookies.length;i++){
            if ("lastAccessTime".equals(cookies[i].getName())){//判断当前cookie中的name是否是想要的cookie
                long l = Long.parseLong(cookies[i].getValue());//如果是想要的cookie，则把cookie中的value取出
                out.write("最后访问时间为："+new Date(l).toLocaleString());//yyy-MM-dd
            }
        }
        //创建cookie，把信息写回到客户端
        Cookie ck = new Cookie("lastAccessTime",System.currentTimeMillis()+"");
        //设置cookie有效时间，单位：秒
        ck.setMaxAge(60*5);//保存时间为五分钟

        //把cookie写回浏览器
        response.addCookie(ck);
    }
}
