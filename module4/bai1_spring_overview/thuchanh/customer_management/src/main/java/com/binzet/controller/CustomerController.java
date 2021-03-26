package com.binzet.controller;

import com.binzet.bean.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomerController {
    private static List<Customer> list = new ArrayList<>();

    static {
        list.add(new Customer(0, "nguyen long phin", "phindeptroai@gmail.com", "da nang"));
        list.add(new Customer(1, "tran huu han", "hanngu@gmail.com", "phu yen"));
        list.add(new Customer(2, "tran huu kien", "kienwibu@gmail.com", "nghe an"));
        list.add(new Customer(3, "nguyen long phin", "phindeptroai@gmail.com", "da nang"));
    }

    @GetMapping("/")
    public String goHome(Model model) {
        model.addAttribute("list", list);
        return "/index";
    }

    @GetMapping("/update")
    public String update(@RequestParam String id, Model model) {
        Customer customer = null;
        for (Customer element : list) {
            if (element.getId() == Integer.parseInt(id)){
                customer = element;
            }
        }
        model.addAttribute("customer", customer);
        return "/update";
    }

    @GetMapping("/save")
    public String save(HttpServletRequest request,Model model){
        for (int i = 0; i < list.size(); i++) {
            if (i == Integer.parseInt(request.getParameter("id"))){
                list.get(i).setName(request.getParameter("name"));
                list.get(i).setEmail(request.getParameter("email"));
                list.get(i).setAddress(request.getParameter("address"));
                break;
            }
        }
        model.addAttribute("list",list);
        return "/index";
    }
}
