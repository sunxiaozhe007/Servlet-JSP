package servlet;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "Upload1Servlet" ,urlPatterns = {"/upload1"})
public class Upload1Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决中文乱码
        //request.setCharacterEncoding("UTF-8");
        //要执行文件上传的操作
        //判断表单是否支持文件上传 即：enctype=multipart/form-data
        boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
        if (!isMultipartContent){
            throw new RuntimeException("your form is not multipart/form-data");
        }

        //创建一个DiskFileItemfactory工厂类
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        //指定临时文件的存储目录
        diskFileItemFactory.setRepository(new File("D:\\"));
        //创建一个ServletFileUpload核心对象
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);

        //解决上传表单项中文乱码
        servletFileUpload.setHeaderEncoding("UTF-8");

        //解析request对象，并得到一个表单项的集合
        try {
        try {
            //限制上传文件大小
            //servletFileUpload.setFileSizeMax(1024*1024*3);//一个不超过3M大小
            //servletFileUpload.setSizeMax(1024*1024*6);//多个不超过6M

            List<FileItem> fileItems = servletFileUpload.parseRequest(request);

            //遍历表单数据
            for (FileItem fileItem : fileItems){
                if (fileItem.isFormField()){
                    //普通表单项
                    processFormField(fileItem);
                }else {
                    //上传表单项
                    processUploadField(fileItem);
                }
            }
        }catch (FileUploadBase.SizeLimitExceededException e){
            System.out.println("文件过大，不能超过6M");
        }
        catch (FileUploadBase.FileSizeLimitExceededException e) {
            System.out.println("文件过大，不能超过3M");
        }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }


    private void processFormField(FileItem fileItem) {
        try {
            //得到文件输入流
            InputStream inputStream = fileItem.getInputStream();

            //创建一个文件存盘的目录
            String directoryRealPath = this.getServletContext().getRealPath("/WEB-INF/upload");
            File storeDirectory = new File(directoryRealPath);//既代表目录又代表文件
            if (!storeDirectory.exists()){
                storeDirectory.mkdirs();//创建指定的目录
            }

            String filename = fileItem.getName();
            filename = filename.substring(filename.lastIndexOf(File.separator)+1);
            filename = filename.substring(filename.lastIndexOf(File.separator)+1);
            filename = UUID.randomUUID()+"_"+filename;
            String childDirectory = makeChildDirectory(storeDirectory,filename);
            //上传文件自动删除临时文件
            fileItem.write(new File(storeDirectory,childDirectory+File.separator+filename));
            fileItem.delete();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private void processUploadField(org.apache.commons.fileupload.FileItem fileItem) throws IOException {

        //得到文件输入流
        InputStream inputStream = fileItem.getInputStream();

        //创建一个文件存盘的目录
        String directoryRealPath = this.getServletContext().getRealPath("/WEB-INF/upload");
        File storeDirectory = new File(directoryRealPath);//既代表目录又代表文件
        if (!storeDirectory.exists()){
            storeDirectory.mkdirs();//创建指定的目录
        }



        //得到上传的名字
        String filename = fileItem.getName();




        //处理文件名
        filename = filename.substring(filename.lastIndexOf(File.separator)+1);
        //效果同上
       /* if (filename!=null){
            filename = FilenameUtils.getName(filename);
        }*/




       //解决文件同名问题
        filename = UUID.randomUUID()+"_"+filename;




        //目录分散：按照日期分散
       // String childDirectory = makeChildDirectory(storeDirectory);

        //目录分散：按照日期分散
        String childDirectory = makeChildDirectory(storeDirectory,filename);


        //在storeDirectory目录下创建一个文件
        File file = new File(storeDirectory,childDirectory+ File.separator +filename);//绝对目录//日期目录//文件名



        //通过文件输出将上传文件保存到磁盘
        FileOutputStream fileOutputStream = new FileOutputStream(file);

        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len=inputStream.read(bytes))!=-1){
            fileOutputStream.write(bytes,0,len);
        }
        fileOutputStream.close();
        inputStream.close();

        fileItem.delete();

    }

    //目录分散：按照目录分散
    private String makeChildDirectory(File storeDirectory,String filename) {
        int hashcode = filename.hashCode();//返回字符串转换的32位hashCode码
        System.out.println(hashcode);
        String code = Integer.toHexString(hashcode);//把hashcode转换为16进制的字符
        System.out.println(code);
        String childDirectory = code.charAt(0)+File.separator+code.charAt(1);
        //创建指定目录
        File file = new File(storeDirectory,childDirectory);
        if (!file.exists()){
            file.mkdirs();
        }
        return String.valueOf(childDirectory);
    }

    //目录分散：按照日期分散
  /*  private String makeChildDirectory(File storeDirectory) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateDirecotry = simpleDateFormat.format(new Date());
        //只管创建目录
        File file = new File(storeDirectory,dateDirecotry);
        if (!file.exists()){
            file.mkdirs();
        }
        return dateDirecotry;
    }*/

    private void processFormField1(org.apache.commons.fileupload.FileItem fileItem) throws UnsupportedEncodingException {
        String fieldName = fileItem.getFieldName();//字段名

        //中文乱码
        String filedValue = fileItem.getString("UTF-8");

        System.out.println(fieldName+"="+filedValue);
        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
