package com.tianxinag.springboot7.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sun.java2d.loops.GeneralRenderer;

@Controller
public class FileController {
    @GetMapping("/detail/{type}/{path}")
    public String toDetail(@PathVariable("type") String type, @PathVariable("path")String path){
            return "detail/"+type+"/"+path;
    }
}
