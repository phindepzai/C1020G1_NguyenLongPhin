package controller;

import model.service.UserService;
import model.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "HomeServlet", urlPatterns = {"", "/homeServlet"})
public class HomeServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (userService.isLog(username,password)){
            HttpSession session = request.getSession();
            session.setAttribute("username",username);
            response.sendRedirect("/customerServlet");
        } else {
            request.setAttribute("isLog",0);
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        if (action == null) {
            action = "login";
        }
        switch (action) {
            case "login":
                if (session.getAttribute("username") == null) {
                    response.sendRedirect("login.jsp");
                    break;
                }
                response.sendRedirect("/employeeServlet");
                break;
            case "logout":
                session.removeAttribute("username");
                response.sendRedirect("login.jsp");
                break;
        }
    }
}
