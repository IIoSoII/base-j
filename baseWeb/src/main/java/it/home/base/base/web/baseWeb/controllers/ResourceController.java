package it.home.base.base.web.baseWeb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResourceController {
    @GetMapping("/")
    public String index(){
        return "/app/index";
    }
}
