package com.furama.validator;

import com.furama.annotation.StartDate;
import com.furama.entity.contract.Contract;
import com.furama.service.contracts.ContractService;
import com.furama.ulti.Check;
import com.furama.ulti.MapManager;
import com.furama.ulti.ObjectUlti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StartDateValidator implements ConstraintValidator<StartDate, String> {
    @Autowired
    private ContractService contractService;

    public void initialize(StartDate constraint) {
    }

    public boolean isValid(String obj, ConstraintValidatorContext context) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        ObjectUlti check = MapManager.map.get(auth.getName());
        if (Check.getDate(Check.getDateYes(), obj) < 1) {
            return false;
        }
        for (Contract c : contractService.findAll()) {
            if (c.getServices().getId().equals(check.getContract().getServices().getId())) {
                if (Check.getDate(c.getEndDate(), obj) <= 0) {
                    return false;
                }
            }
        }
        check.setStartDate(obj);
        return true;
    }
}
