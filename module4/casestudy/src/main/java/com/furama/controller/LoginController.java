package com.furama.controller;

import com.furama.entity.employee.Employee;
import com.furama.repository.employee.RoleRepository;
import com.furama.repository.employee.UserRepository;
import com.furama.repository.employee.UserRoleRepository;
import com.furama.service.employees.EmployeeService;
import com.furama.service.services.ServicesService;
import com.furama.ulti.MapManager;
import com.furama.ulti.ObjectUlti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.HashMap;

@Controller
public class LoginController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/login")
    public String loginPage(@CookieValue(value = "user", required = false) String user, Model model) {
        if (user != null) {
            if (!user.equals("")) {
                model.addAttribute("username", user);
            }
        }
        return "login/login";
    }

    @GetMapping("/")
    public String welcomePage(Principal principal, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @CookieValue(value = "remember", required = false) String remember) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (MapManager.map == null){
            MapManager.map = new HashMap<>();
        }
        if (MapManager.map.get(auth.getName()) == null){
            MapManager.map.put(auth.getName(),new ObjectUlti());
        }
        if (principal != null) {
            Employee employee = employeeService.findByEmail(principal.getName());
            httpServletRequest.getSession().setAttribute("employee", employee);
        }
        if (remember != null) {
            if (!remember.equals("") && principal != null) {
                Cookie cookie = new Cookie("user", principal.getName());
                httpServletResponse.addCookie(cookie);
                Cookie rememberCookie = new Cookie("remember", null);
            } else {
                httpServletResponse.addCookie(new Cookie("user", null));
            }
        } else {
            httpServletResponse.addCookie(new Cookie("user", null));
        }
        return "login/welcome";
    }

    @GetMapping("/403")
    public String notAccessPage(Principal principal) {
        System.out.println("principal:" + principal.getName());
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("user:" + user.getUsername());
        return "login/403";
    }
}
