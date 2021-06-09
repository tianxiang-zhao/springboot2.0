package com.tianxinag.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

@Controller
public class LoginController {
    @RequestMapping("/toLoginPage")
    public String login(Model model){
        int i=Calendar.getInstance().get(Calendar.YEAR);
        model.addAttribute("currentYear",i);
        return "login";
    }

}
