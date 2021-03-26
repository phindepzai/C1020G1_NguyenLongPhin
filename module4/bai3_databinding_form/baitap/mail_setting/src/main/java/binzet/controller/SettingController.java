package binzet.controller;

import binzet.model.Setting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SettingController {
    private Setting settingCon;
    @GetMapping("/home")
    public String home(){
        return "/home";
    }

    @GetMapping("/setting")
    public String setting(Model model){
        List<String> languages = new ArrayList<>();
        List<Integer> pageSizes = new ArrayList<>();
        languages.add("English");
        languages.add("Vietnamese");
        languages.add("Japanese");
        languages.add("Chinese");
        pageSizes.add(5);
        pageSizes.add(10);
        pageSizes.add(15);
        pageSizes.add(25);
        pageSizes.add(50);
        pageSizes.add(100);
        if (settingCon == null){
            settingCon = new Setting();
        }
        model.addAttribute("languages",languages);
        model.addAttribute("pageSizes",pageSizes);
        model.addAttribute("setting", settingCon);
        return "/setting";
    }

    @GetMapping("/update")
    public String update(@ModelAttribute Setting setting,Model model){
        settingCon = setting;
        return "redirect:/home";
    }
}
