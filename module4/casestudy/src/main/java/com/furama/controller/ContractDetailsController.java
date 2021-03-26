package com.furama.controller;

import com.furama.entity.contract.Contract;
import com.furama.entity.contract.ContractDetail;
import com.furama.service.contracts.AttachServiceService;
import com.furama.service.contracts.ContractDetailService;
import com.furama.service.contracts.ContractService;
import com.furama.ulti.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/details")
public class ContractDetailsController {
    @Autowired
    private ContractDetailService contractDetailService;
    @Autowired
    private ContractService contractService;
    @Autowired
    private AttachServiceService attachServiceService;

    @GetMapping("/list")
    public String list(Model model,@PageableDefault(size = 5) Pageable pageable) {
        Page<ContractDetail> all = contractDetailService.findAll(pageable);
        model.addAttribute("list", all);
        return "contracts/detailsList";
    }

    @GetMapping("/view/{id}")
    public String viewByContract(@PathVariable int id, Model model, @PageableDefault(size = 5) Pageable pageable) {
        Contract contract = contractService.findById(id);
        if (contract == null){
            return "login/404";
        }
        model.addAttribute("list",contractDetailService.findByContract(contract,pageable));
        model.addAttribute("day", Check.getDate(contract.getStartDate(),contract.getEndDate()));
        model.addAttribute("contract",contract);
        model.addAttribute("services",contract.getServices());
        return "contracts/detailsList";
    }

    @GetMapping("/view/detail/{id}")
    public String view(@PathVariable int id,Model model){
        if (contractDetailService.findById(id) == null){
            return "login/404";
        }
        model.addAttribute("details",contractDetailService.findById(id));
        return "contracts/detailsView";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("details",new ContractDetail());
        model.addAttribute("contractList",contractService.findAll());
        model.addAttribute("attachList",attachServiceService.findAll());
        return "contracts/saveDetails";
    }

    @GetMapping("/create/{id}")
    public String create(Model model,@PathVariable int id){
        ContractDetail detail = new ContractDetail();
        detail.setContract(contractService.findById(id));
        model.addAttribute("details", detail);
        model.addAttribute("contract",contractService.findById(id));
        model.addAttribute("attachList",attachServiceService.findAll());
        return "contracts/saveDetails";
    }

    @PostMapping("/save")
    public String save(Model model, @Validated ContractDetail contractDetail, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            model.addAttribute("details",contractDetail);
            model.addAttribute("contractList",contractService.findAll());
            model.addAttribute("attachList",attachServiceService.findAll());
            return "contracts/saveDetails";
        }
        contractDetailService.save(contractDetail);
        return "redirect:/details/list";
    }
}
