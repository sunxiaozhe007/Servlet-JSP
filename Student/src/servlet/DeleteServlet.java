package servlet;

import service.ServiceStudent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DeleteServlet",urlPatterns = {"/delete"})
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String num = request.getParameter("num");
        ServiceStudent serviceStudent = new ServiceStudent();
        try {
            serviceStudent.deleteStudent(num);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/list").forward(request,response);
    }
}
