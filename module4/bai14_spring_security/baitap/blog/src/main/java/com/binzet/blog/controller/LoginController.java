package com.binzet.blog.controller;

import com.binzet.blog.entity.AppRole;
import com.binzet.blog.entity.AppUser;
import com.binzet.blog.entity.UserRole;
import com.binzet.blog.repository.AppRoleRepository;
import com.binzet.blog.repository.AppUserRepository;
import com.binzet.blog.repository.UserRoleRepository;
import com.binzet.blog.ulti.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class LoginController {
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private AppRoleRepository appRoleRepository;

    @RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
    public String welcomePage(Model model) {
        model.addAttribute("title", "Welcome");
        model.addAttribute("message", "This is welcome page!");
        return "welcomePage";
    }

    @GetMapping("/save")
    public String re(){
        AppUser appUser = new AppUser();
        appUser.setUserId(Long.parseLong("3"));
        appUser.setEncrytedPassword(bCryptPasswordEncoder.encode("123"));
        appUser.setUserName("phindepzai");
        appUser.setEnabled(true);
        appUserRepository.save(appUser);
        UserRole userRole = new UserRole();
        userRole.setAppUser(appUser);
        userRole.setAppRole(appRoleRepository.findById(Long.parseLong("2")).orElse(null));
        userRoleRepository.save(userRole);
        return "redirect:/";
    }

//    @RequestMapping(value = "/admin", method = RequestMethod.GET)
//    public String adminPage(Model model, Principal principal) {
//
//        User loginedUser = (User) ((Authentication) principal).getPrincipal();
//
//        String userInfo = WebUtils.toString(loginedUser);
//        model.addAttribute("userInfo", userInfo);
//
//        return "adminPage";
//    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {

        return "login";
    }

//    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
//    public String logoutSuccessfulPage(Model model) {
//        model.addAttribute("title", "Logout");
//        return "successPage";
//    }

//    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
//    public String userInfo(Model model, Principal principal) {
//
//        // Sau khi user login thanh cong se co principal
//        String userName = principal.getName();
//
//        System.out.println("User Name: " + userName);
//
//        User loginedUser = (User) ((Authentication) principal).getPrincipal();
//
//        String userInfo = WebUtils.toString(loginedUser);
//        model.addAttribute("userInfo", userInfo);
//
//        return "infoPage";
//    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {

        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();

            String userInfo = WebUtils.toString(loginedUser);

            model.addAttribute("userInfo", userInfo);

            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);

        }

        return "403";
    }
}
