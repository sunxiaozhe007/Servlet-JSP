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
import java.util.List;

@WebServlet(name = "ListServlet",urlPatterns = {"/list"})
public class ListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        ServiceStudent serviceStudent = new ServiceStudent();
        try {
            List<Student> list = serviceStudent.listStudent();
            if (list!=null){
                request.setAttribute("student",list);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

}
