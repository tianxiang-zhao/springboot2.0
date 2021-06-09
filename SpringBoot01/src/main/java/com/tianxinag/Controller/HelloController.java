package com.tianxinag.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //混合注解：@repsonseBody+@Controller
public class HelloController {
@GetMapping("/hello")//@GetMapping("/hello") 相当于@RequestMapping(value="hello",RequstMethod.Get)
    public String hello(){
        return "hello Springboot";
    }

}
