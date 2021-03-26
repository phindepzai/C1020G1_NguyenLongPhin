package com.furama.controller;

import com.furama.entity.contract.Contract;
import com.furama.repository.contract.ContractRepository;
import com.furama.service.contracts.ContractService;
import com.furama.service.customers.CustomerService;
import com.furama.service.employees.EmployeeService;
import com.furama.service.services.HouseService;
import com.furama.service.services.RoomService;
import com.furama.service.services.VillaService;
import com.furama.ulti.Check;
import com.furama.ulti.MapManager;
import com.furama.ulti.ObjectUlti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;


@Controller
@RequestMapping("/contracts")
public class ContractController {
    @Autowired
    private ContractService contractService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private VillaService villaService;
    @Autowired
    private HouseService houseService;
    @Autowired
    private RoomService roomService;

    @GetMapping("/list")
    public String list(Model model,@PageableDefault(size = 5) Pageable pageable){
        model.addAttribute("list",contractService.findAll(pageable));
        return "contracts/list";
    }

    @GetMapping("/list/active")
    public String listActive(Model model,@PageableDefault(size = 5) Pageable pageable){
        model.addAttribute("list",contractService.findAllByContractActive(Check.getDateYes(),pageable));
        return "contracts/listActive";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("contract",new Contract());
        model.addAttribute("employeeList",employeeService.findAll());
        model.addAttribute("customerList",customerService.findAll());
        model.addAttribute("villaList",villaService.findAll());
        model.addAttribute("houseList",houseService.findAll());
        model.addAttribute("roomList",roomService.findAll());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        ObjectUlti check = MapManager.map.get(auth.getName());
        check.setCreate(true);
        return "contracts/save";
    }

    @GetMapping("/view/{id}")
    public String view(Model model,@PathVariable int id){
        if (contractService.findById(id) == null){
            return "login/404";
        }
        model.addAttribute("contract",contractService.findById(id));
        return "contracts/view";
    }

    @PostMapping("/save")
    public String save(Model model, @Validated Contract contract, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            model.addAttribute("contract",contract);
            model.addAttribute("employeeList",employeeService.findAll());
            model.addAttribute("customerList",customerService.findAll());
            model.addAttribute("villaList",villaService.findAll());
            model.addAttribute("houseList",houseService.findAll());
            model.addAttribute("roomList",roomService.findAll());
            return "contracts/save";
        }
        contractService.save(contract);
        return "redirect:/contracts/list";
    }
}
