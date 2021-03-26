package com.example.demo.controller;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.entity.UserRole;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){

        return "login";
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }

    @GetMapping("/dba/index")
    public String dba(){
        return "dba";
    }

    @GetMapping("/403")
    public String error(){
        return "403";
    }

    @GetMapping("create")
    public String save(){
        User user = new User();
        user.setUsername("ppp");
        user.setPassword(new BCryptPasswordEncoder().encode("123"));
        userRepository.save(user);
        Role role = roleRepository.getOne(2);
        UserRole userRole = new UserRole();
        userRole.setRole(role);
        userRole.setUser(user);
        userRoleRepository.save(userRole);
        return "redirect:/login";
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "welcome";
    }
}
