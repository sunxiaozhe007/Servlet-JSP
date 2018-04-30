package servlet;

import domain.Student;
import service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "servlet.StudentUpdateServlet",urlPatterns = {"/update"})
public class StudentUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        StudentServiceImpl studentService = new StudentServiceImpl();
        Student student = studentService.findId(id);
        request.setAttribute("student",student);
        request.getRequestDispatcher("update.jsp").forward(request,response);
    }
}
