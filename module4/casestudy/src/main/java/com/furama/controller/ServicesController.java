package com.furama.controller;

import com.furama.entity.services.*;
import com.furama.service.services.HouseService;
import com.furama.service.services.RoomService;
import com.furama.service.services.ServicesService;
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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/services")
public class ServicesController {
    @Autowired
    private VillaService villaService;
    @Autowired
    private HouseService houseService;
    @Autowired
    private RoomService roomService;
    @Autowired
    private ServicesService servicesService;

    @GetMapping("/villas")
    public String villas(Model model, @PageableDefault(size = 5) Pageable pageable) {
        model.addAttribute("list", villaService.findAll(pageable));
        model.addAttribute("type", "villa");
        return "/services/list";
    }

    @GetMapping("/houses")
    public String houses(Model model, @PageableDefault(size = 5) Pageable pageable) {
        model.addAttribute("list", houseService.findAll(pageable));
        return "services/list";
    }

    @GetMapping("/rooms")
    public String room(Model model, @PageableDefault(size = 5) Pageable pageable) {
        model.addAttribute("list", roomService.findAll(pageable));
        return "services/list";
    }

    @GetMapping("/create/{type}")
    public String create(Model model, @PathVariable String type) {
        List<ServicesType> servicesType = servicesService.findAllServicesType();
        type = type.toLowerCase();
        if (type.equals("villa")) {
            model.addAttribute("services", new Villa());
            model.addAttribute("serviceType1", servicesType.get(0));
        } else if (type.equals("house")) {
            model.addAttribute("services", new House());
            model.addAttribute("serviceType1", servicesType.get(1));
        } else {
            model.addAttribute("services", new Room());
            model.addAttribute("serviceType1", servicesType.get(2));
        }
        model.addAttribute("servicesTypeList", servicesType);
        model.addAttribute("rentTypeList", servicesService.findAllRentType());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        ObjectUlti check = MapManager.map.get(auth.getName());
        check.setCreate(true);
        return "services/save";
    }

    @PostMapping("/save/Villa")
    public String saveVilla(@Validated Villa villa, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("services", villa);
            model.addAttribute("serviceType1", servicesService.findAllServicesType().get(0));
            model.addAttribute("servicesTypeList", servicesService.findAllServicesType());
            model.addAttribute("rentTypeList", servicesService.findAllRentType());
            return "services/save";
        }
        villaService.save(villa);
        return "redirect:/services/villas";
    }

    @PostMapping("/save/House")
    public String saveHouse(@Validated House house, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("services", house);
            model.addAttribute("serviceType1", servicesService.findAllServicesType().get(1));
            model.addAttribute("servicesTypeList", servicesService.findAllServicesType());
            model.addAttribute("rentTypeList", servicesService.findAllRentType());
            return "services/save";
        }
        houseService.save(house);
        return "redirect:/services/houses";
    }

    @PostMapping("/save/Room")
    public String saveRoom(@Validated Room room, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("services", room);
            model.addAttribute("serviceType1", servicesService.findAllServicesType().get(2));
            model.addAttribute("servicesTypeList", servicesService.findAllServicesType());
            model.addAttribute("rentTypeList", servicesService.findAllRentType());
            return "services/save";
        }
        roomService.save(room);
        return "redirect:/services/rooms";
    }

    @GetMapping("/view/{id}")
    public String viewServices(@PathVariable String id,Model model) {
        if (villaService.findById(id) != null) {
            model.addAttribute("services",villaService.findById(id));
        } else if (houseService.findById(id) != null) {
            model.addAttribute("services",houseService.findById(id));
        } else if (roomService.findById(id) != null) {
            model.addAttribute("services",roomService.findById(id));
        }
        return "services/view";
    }
}

