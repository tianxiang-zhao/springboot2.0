package com.tianxinag.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Calendar;

@Controller
public class LoginController {
//    @RequestMapping("/toLoginPage")  注释掉仍可以访问
    public String login(Model model){
        int i=Calendar.getInstance().get(Calendar.YEAR);
        model.addAttribute("currentYear",i);
        return "login";
    }

}
