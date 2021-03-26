package controller;

import model.bean.customer.Customer;
import model.bean.customer.CustomerType;
import model.service.CustomerService;
import model.service.Validate;
import model.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customerServlet")
public class CustomerServlet extends HttpServlet {

    private CustomerService customerService = new CustomerServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        Customer customer;
        String name = request.getParameter("name");
        CustomerType customerType = customerService.getCustomerType(Integer.parseInt(request.getParameter("typeId")));
        String dateOfBirth = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        if (request.getParameter("id") != null) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            customerService.save(new Customer(id, name, customerType, dateOfBirth, gender, idCard, phone, email, address));
        }
        boolean isWrong = false;
        if (!Validate.checkDate(dateOfBirth)){
            request.setAttribute("dob","Wrong Format Ex : 12-12-2001");
            isWrong = true;
        } else {
            request.setAttribute("dob",dateOfBirth);
        }
        if (!Validate.checkIdCard(idCard)){
            request.setAttribute("idCard","Wrong Format Ex : 123456789 or 123456789012");
            isWrong = true;
        } else {
            request.setAttribute("idCard",idCard);
        }
        if (!Validate.checkPhoneNumber(phone)){
            request.setAttribute("phone","Wrong Format Ex : (84|0)9(0|1)XXXXXXX");
            isWrong = true;
        } else {
            request.setAttribute("phone",phone);
        }
        if (!Validate.checkEmail(email)){
            request.setAttribute("email","Wrong Format Ex : phindeptroai@gmail.com");
            isWrong = true;
        } else {
            request.setAttribute("email",email);
        }
        if (isWrong){
            request.setAttribute("name",name);
            request.setAttribute("customerType",customerType);
            request.setAttribute("gender",gender);
            request.setAttribute("address",address);
            request.setAttribute("isWrong",1);
            request.setAttribute("isCreate", 0);
            request.getRequestDispatcher("save_customer.jsp").forward(request,response);
        } else {
            customerService.save(new Customer(name, customerType, dateOfBirth, gender, idCard, phone, email, address));
            goCustomerList(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "update":
                request.setAttribute("customer", customerService.findByID(Integer.parseInt(request.getParameter("id"))));
                request.setAttribute("isCreate", 1);
                request.setAttribute("typeList",customerService.findAllCustomerType());
                request.getRequestDispatcher("save_customer.jsp").forward(request, response);
            case "create":
                request.setAttribute("isWrong",0);
                request.setAttribute("isCreate", 0);
                request.setAttribute("typeList",customerService.findAllCustomerType());
                request.getRequestDispatcher("save_customer.jsp").forward(request,response);
                break;
            case "delete":
                customerService.delete(Integer.parseInt(request.getParameter("id")));
                break;
            case "deleteAll":
                customerService.deleteAll();
                break;
        }
        goCustomerList(request, response);
    }

    private void goCustomerList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page;
        int size;
        String key = request.getParameter("key");
        if (request.getParameter("page") == null) {
            page = 1;
        } else {
            page = Integer.parseInt(request.getParameter("page"));
        }
        if (key == null){
            request.setAttribute("list", customerService.findAll(page));
            size = customerService.size();
        } else {
            request.setAttribute("list",customerService.findByName(key,page));
            size = customerService.sizeName(key);
        }
        request.setAttribute("key",key);
        request.setAttribute("size", size);
        request.setAttribute("numPage", ((size - 1) / 7) + 1);
        request.setAttribute("page", page);
        request.setAttribute("typeList", customerService.findAllCustomerType());
        request.getRequestDispatcher("customer.jsp").forward(request, response);
    }
}
