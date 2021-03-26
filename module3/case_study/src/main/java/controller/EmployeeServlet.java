package controller;

import model.bean.employee.*;
import model.service.EmployeeService;
import model.service.Validate;
import model.service.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employeeServlet")
public class EmployeeServlet extends HttpServlet {
    private EmployeeService employeeService = new EmployeeServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String name = request.getParameter("name");
        String dateOfBirth = request.getParameter("dob");
        String idCard = request.getParameter("idCard");
        String salary = request.getParameter("salary");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Position position = employeeService.findPosition(Integer.parseInt(request.getParameter("position")));
        Division division = employeeService.findDivision(Integer.parseInt(request.getParameter("division")));
        EducationDegree educationDegree = employeeService.findED(Integer.parseInt(request.getParameter("eD")));
        User user;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean isWrong = false;
        if (!Validate.checkDate(dateOfBirth)) {
            request.setAttribute("dob", "Wrong Format Ex : 12-12-2001");
            isWrong = true;
        } else {
            request.setAttribute("dob",dateOfBirth);
        }
        if (!Validate.isPositive(salary)) {
            request.setAttribute("salary", "Wrong Format Ex : 1000");
            isWrong = true;
        } else {
            request.setAttribute("salary",salary);
        }
        if (!Validate.checkIdCard(idCard)) {
            request.setAttribute("idCard", "Wrong Format Ex : 123456789 or 123456789012");
            isWrong = true;
        } else {
            request.setAttribute("idCard",idCard);
        }
        if (!Validate.checkPhoneNumber(phone)) {
            request.setAttribute("phone", "Wrong Format Ex : (84|0)9(0|1)XXXXXXX");
            isWrong = true;
        } else {
            request.setAttribute("phone",phone);
        }
        if (!Validate.checkEmail(email)) {
            request.setAttribute("email", "Wrong Format Ex : phindeptroai@gmail.com");
            isWrong = true;
        } else {
            request.setAttribute("email",email);
        }
        if (isWrong){
            request.setAttribute("name", name);
            request.setAttribute("address", address);
            request.setAttribute("position", position);
            request.setAttribute("division", division);
            request.setAttribute("ed", educationDegree);
            request.setAttribute("username",username);
            request.setAttribute("password",password);
        }
        if (action.equals("create")){
            if (employeeService.findUser(username) == null && !isWrong){
                user = new User(username,password);
                employeeService.saveUser(user);
                employeeService.save(new Employee(name,dateOfBirth,idCard,Double.parseDouble(salary),phone,email,address,position,educationDegree,division,user));
            } else {
                request.setAttribute("isWrong",1);
                request.getRequestDispatcher("save_employee.jsp").forward(request,response);
            }
        } else {
            if (!isWrong){
                Integer id = Integer.parseInt(request.getParameter("id"));
                user = employeeService.findUser(username);
                user.setPassWord(password);
                employeeService.saveUser(user);
                employeeService.save(new Employee(id,name,dateOfBirth,idCard,Double.parseDouble(salary),phone,email,address,position,educationDegree,division,user));
            } else {
                request.setAttribute("isWrong",1);
                request.getRequestDispatcher("save_employee.jsp").forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "update":
                request.setAttribute("employee", employeeService.findByID(Integer.parseInt(request.getParameter("id"))));
                request.setAttribute("isCreate", 1);
                request.setAttribute("positionList", employeeService.positionList());
                request.setAttribute("edList", employeeService.educationList());
                request.setAttribute("divisionList", employeeService.divisionList());
                request.setAttribute("userList", employeeService.userList());
                request.getRequestDispatcher("save_employee.jsp").forward(request, response);
                break;
            case "create":
                request.setAttribute("isCreate", 0);
                request.setAttribute("positionList", employeeService.positionList());
                request.setAttribute("edList", employeeService.educationList());
                request.setAttribute("divisionList", employeeService.divisionList());
                request.setAttribute("userList", employeeService.userList());
                request.getRequestDispatcher("save_employee.jsp").forward(request, response);
                break;
            case "delete":
                employeeService.delete(Integer.parseInt(request.getParameter("id")));
                goEmployeeList(request, response);
                break;
            case "deleteAll":

            default:
                goEmployeeList(request, response);
        }
    }

    private void goEmployeeList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page;
        String key = request.getParameter("key");
        if (request.getParameter("page") == null) {
            page = 1;
        } else {
            page = Integer.parseInt(request.getParameter("page"));
        }
        int size;
        if (key == null) {
            key = "";
            request.setAttribute("listEmployee", employeeService.findAll(page));
            size = employeeService.size();
        } else {
            request.setAttribute("listEmployee", employeeService.findByName(key, page));
            size = employeeService.sizeName(key);
        }
        request.setAttribute("size", size);
        request.setAttribute("page", page);
        request.setAttribute("numPage", ((size - 1) / 7) + 1);
        request.setAttribute("key", key);
        request.setAttribute("positionList", employeeService.positionList());
        request.setAttribute("edList", employeeService.educationList());
        request.setAttribute("divisionList", employeeService.divisionList());
        request.setAttribute("userList", employeeService.userList());
        request.getRequestDispatcher("employee.jsp").forward(request, response);
    }
}
