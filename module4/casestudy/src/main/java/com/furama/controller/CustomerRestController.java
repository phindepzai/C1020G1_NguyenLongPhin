package com.furama.controller;

import com.furama.entity.customer.Customer;
import com.furama.service.customers.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
@CrossOrigin("*")
public class CustomerRestController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/search")
    public ResponseEntity<Page<Customer>> search(@PageableDefault(size = 5) Pageable pageable, @RequestParam(required = false) String key){
        pageable = pageable.previousOrFirst();
        return new ResponseEntity<Page<Customer>>(customerService.findAllByName(key,pageable), HttpStatus.OK);
    }
}
