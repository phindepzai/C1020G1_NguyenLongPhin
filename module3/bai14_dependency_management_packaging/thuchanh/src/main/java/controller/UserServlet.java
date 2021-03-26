package controller;

import bean.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserServlet",urlPatterns = {"","/userServlet"})
public class UserServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user;
        if (id == null){
            user = new User(name,email,country);
        } else {
            user = new User(Integer.parseInt(id),name,email,country);
        }
        userService.save(user);
        goHome(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String country = request.getParameter("country");
        int page;
        if (action == null){
            action = "";
        }
        if (country == null){
            country = "";
        }
        switch (action){
            case "update":
                User user = userService.findById(Integer.parseInt(request.getParameter("id")));
                request.setAttribute("user",user);
                request.getRequestDispatcher("update_user.jsp").forward(request,response);
                break;
            case "delete":
                userService.delete(Integer.parseInt(request.getParameter("id")));
                goHome(request,response);
                break;
            case "sort":
                page = getPage(request);
                request.setAttribute("page",page);
                List<User> userList = userService.sortByName(page);
                request.setAttribute("size",userService.size());
                request.setAttribute("isSort","home");
                request.setAttribute("numPage",userService.numPage());
                request.setAttribute("list",userList);
                request.getRequestDispatcher("index.jsp").forward(request,response);
                break;
            case "search":
                page = getPage(request);
                request.setAttribute("page",page);
                List<User> list = userService.findByCountry(country,page);
                request.setAttribute("size",userService.size());
                request.setAttribute("isSort","sort");
                request.setAttribute("numPage",userService.numPage());
                request.setAttribute("country",country);
                request.setAttribute("list",list);
                request.getRequestDispatcher("index.jsp").forward(request,response);
                break;
            default:
                goHome(request,response);
        }
    }

    private void goHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = getPage(request);
        request.setAttribute("page",page);
        request.setAttribute("size",userService.size());
        request.setAttribute("numPage",userService.numPage());
        List<User> userList = userService.findAll(page);
        request.setAttribute("isSort","sort");
        request.setAttribute("list",userList);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    private int getPage(HttpServletRequest request) {
        String pageString = request.getParameter("page");
        int page;
        if (pageString == null){
            page = 1;
        } else {
            page = Integer.parseInt(pageString);
        }
        return page;
    }
}
