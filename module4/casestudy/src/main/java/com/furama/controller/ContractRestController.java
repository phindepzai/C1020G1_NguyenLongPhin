package com.furama.controller;

import com.furama.entity.contract.Contract;
import com.furama.service.contracts.ContractService;
import com.furama.ulti.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contracts")
public class ContractRestController {
    @Autowired
    public ContractService contractService;
    @GetMapping("/active/search")
    public ResponseEntity<Page<Contract>> listActive(@PageableDefault(size = 5)Pageable pageable,@RequestParam(required = false) String key){
        if (key == null){
            key = "";
        }
        pageable = pageable.previousOrFirst();
        return new ResponseEntity<Page<Contract>>(contractService.findAllByContractActiveContaining(key,pageable), HttpStatus.OK);
    }

    @GetMapping("search")
    public ResponseEntity<Page<Contract>> list(@PageableDefault(size = 5)Pageable pageable,@RequestParam(required = false) String key) {
        if (key == null) {
            key = "";
        }
        pageable = pageable.previousOrFirst();
        return new ResponseEntity<Page<Contract>>(contractService.findAllContaining(key, pageable), HttpStatus.OK);
    }
}
