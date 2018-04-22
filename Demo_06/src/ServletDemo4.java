import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 验证码实现
 */
@WebServlet(name = "ServletDemo4" , urlPatterns = {"/Demo4"})
public class ServletDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int heigth = 25;
        int width = 110;
        //创建图像对象
        BufferedImage img = new BufferedImage(width , heigth , BufferedImage.TYPE_INT_RGB);

        //创建画笔
        Graphics g = img.createGraphics();

        //给图片添加背景色
        g.setColor(Color.PINK);
        g.fillRect(1 , 1, width-2, heigth-2);

        //边框上色
        g.setColor(Color.BLUE);
        g.drawRect(0 , 0 , width-1, heigth-1);

        //设置文本样式
        g.setColor(Color.BLUE);
        g.setFont(new Font("宋体" , Font.BOLD|Font.ITALIC , 15 ));

        //添加文本
        Random rand = new Random();
        int pos = 20;
        for (int i=0;i<4;i++){
            g.drawString(rand.nextInt(10)+"",pos,20);
            pos +=20;
        }
        //添加干扰线条
        for (int i = 0;i<9;i++){
            g.drawLine(rand.nextInt(width),rand.nextInt(heigth),rand.nextInt(width), rand.nextInt(heigth));
        }



        //以流的方式输入客户端
        ImageIO.write(img , "jpg" , response.getOutputStream());
    }
}
