package servlet;

import domain.Student;
import service.ServiceStudent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UpdateServlet",urlPatterns = {"/update"})
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Student student = new Student();
        student.setId(Integer.parseInt(request.getParameter("id")));
        student.setNum(request.getParameter("num"));
        student.setName(request.getParameter("name"));
        student.setSex(request.getParameter("sex"));
        student.setAge(request.getParameter("age"));
        student.setSchool(request.getParameter("school"));
        ServiceStudent serviceStudent = new ServiceStudent();
        try {
            serviceStudent.updateStudent(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/list").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);


    }
}
