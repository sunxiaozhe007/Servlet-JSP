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

@WebServlet(name = "Update1Servlet",urlPatterns = {"/update1"})
public class Update1Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ServiceStudent serviceStudent = new ServiceStudent();
        try {
            Student student = serviceStudent.findId(id);
            request.setAttribute("student",student);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/update.jsp").forward(request,response);
    }
}
