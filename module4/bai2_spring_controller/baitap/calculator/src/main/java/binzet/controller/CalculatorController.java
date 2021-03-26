package binzet.controller;

import binzet.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("")
    public String goHome(){
        return "/home";
    }

    @GetMapping("/calculate")
    public String calculate(@RequestParam int number1, @RequestParam int number2, @RequestParam String operate, Model model){
        String result;
        model.addAttribute("number1",number1);
        model.addAttribute("number2",number2);
        result = calculatorService.getResult(number1,number2,operate);
        model.addAttribute("result",result);
        return "/home";
    }
}
