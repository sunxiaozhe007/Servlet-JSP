package app02a.hiddenfields;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet")
public class CustomerServlet extends HttpServlet {
    private static final long serialVersionUID = -20L;
    private List<Customer> customers = new ArrayList<Customer>();

    @Override
    public void init()throws ServletException{
        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setName("Donal.D");
        customer1.setCity("Miami");
        customers.add(customer1);

        Customer customer2 = new Customer();
        customer2.setId(2);
        customer2.setName("Mickey.M");
        customer2.setCity("Orlando");
        customers.add(customer2);


    }
    private void sendCustomerList(HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html><head><title>Customers</title></head>"
                        + "<body><h2>Customers</h2>");
        writer.println("<ul>");
        for (Customer customer : customers){
            writer.println("<li>"+customer.getName()
            +"（"+customer.getCity()+"）("
            +"<a href='editCustomer?id=" +customer.getId()
            +"'>edit</a>)");
        }
        writer.println("</ul>");
        writer.println("</body></html>");
    }
    private Customer getCustomer(int customerID){
        for (Customer customer : customers){
            if (customer.getId() == customerID){
                return customer;
            }
        }
        return null;
    }
    private void sendEditCustomerForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        int customerID = 0;
        customerID = Integer.parseInt(request.getParameter("id"));
        Customer customer = getCustomer(customerID);
        if (customer != null){
            writer.println("<html><head>"
                            + "<title>Edit Customer</title></head>"
                            + "<body><h2>Edit Customer</h2>"
                            + "<form method='post'"
                            + "action='updateCustomer'>");
            writer.println("<input type='hidden' name='id' value='"
                            + customerID + "'/>");
            writer.println("<table>");
            writer.println("<tr><td>Name:</td><td>"
                            + "<input name='name' value='" +
                            customer.getName().replaceAll("'", "&#39;")
                            + "'/></td></tr>");
            writer.println("<tr><td>City:</td><td>"
                            + "<input name='city' value='" +
                            customer.getCity().replaceAll("'", "&#39;")
                            + "'/></td></tr>");
            writer.println("<tr>"
                            + "<td colspan='2' style='text-align:right'>"
                            + "<input type='submit' value='Update'/></td>"
                            + "</tr>");
            writer.println("<tr><td colspan='2'>"
                            + "<a href='customer'>Csustomer List</a>"
                            + "</td></tr>");
            writer.println("</table>");
            writer.println("</from></body>");
        }else{
            writer.println("No customer found");
        }
    }
    @Override
    public  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String uri = request.getRequestURI();
            if (uri.endsWith("/customer")){
                sendCustomerList(response);
            }else if (uri.endsWith("/editCustomer")){
                sendEditCustomerForm(request,response);
            }
    }
    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
        int customerID = 0;
        customerID = Integer.parseInt(request.getParameter("id"));
        Customer customer = getCustomer(customerID);
        if (customer != null){
            customer.setName(request.getParameter("name"));
            customer.setCity(request.getParameter("city"));
        }
        sendCustomerList(response);
    }
}
