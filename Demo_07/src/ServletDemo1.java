import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * 获取表单信息
 */
@WebServlet(name = "ServletDemo1" , urlPatterns = {"/Demo1"})
public class ServletDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取表单数据
        request.setCharacterEncoding("UTF-8");
        //第一种方法
       /* String  userName= request.getParameter("userName");
        String  pwd= request.getParameter("pwd");
        String  sex = request.getParameter("sex");
        String[] hobbys = request.getParameterValues("hobby");
        String city = request.getParameter("city");

        System.out.println(userName);
        System.out.println(pwd);
        System.out.println(sex);

        for (int i = 0;hobbys!=null&&i<hobbys.length;i++){
            System.out.print(hobbys[i]+"\t");
        }
        System.out.println();
        System.out.println(city);*/
       //第二种方法
       /* Enumeration names = request.getParameterNames();
        while (names.hasMoreElements()){
            String name = (String) names.nextElement();//得到一个name名

            String[] values = request.getParameterValues(name);//根据name名得到value值
            for (int i = 0;values!=null&&i<values.length;i++){
                System.out.println(name +":" + values[i]);
            }
        }*/

       user u = new user();
        System.out.println("封装数据前："+u);
       Map<String, String[]> map = request.getParameterMap();
       for (Map.Entry<String,String[]>m : map.entrySet()) {
           String name = m.getKey();
           String[] value = m.getValue();
           //创建一个属性描述器
           try {
               PropertyDescriptor pd = new PropertyDescriptor(name, user.class);
              //得到setter方法
               Method setter = pd.getWriteMethod();
           if (value.length == 1) {
               setter.invoke(u, value[0]);
           } else {
               setter.invoke(u,(Object) value);//复选框赋值

           }
       }
           catch (IntrospectionException e) {
               e.printStackTrace();
           } catch (IllegalAccessException e) {
               e.printStackTrace();
           } catch (InvocationTargetException e) {
               e.printStackTrace();
           }
       }
        System.out.println("封装数据后:"+u);

    }
}
