package controller;

import bean.Customer;
import service.CustomerService;
import service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CustomerServlet",urlPatterns = {"","/customerServlet"})
public class CustomerServlet extends HttpServlet {

    private CustomerService customerService = new CustomerServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idString = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer;
        if (idString == null){
            customer = new Customer(name,email,address);
        } else {
            customer = new Customer(Integer.parseInt(idString),name,email,address);
        }
        customerService.save(customer);
        home(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                response.sendRedirect("create_customer.jsp");
                break;
            case "update":
                showUpdatePage(request, response);
                break;
            case "delete":
                Integer id = Integer.parseInt(request.getParameter("id"));
                customerService.delete(id);
                home(request,response);
                break;
            default:
                home(request, response);
        }
    }

    private void showUpdatePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("customer", customerService.findById(id));
        request.getRequestDispatcher("update_customer.jsp").forward(request,response);
    }

    private void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list",customerService.findAll());
        request.getRequestDispatcher("display.jsp").forward(request,response);
    }
}
