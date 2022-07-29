package it.home.base.base.web.baseWeb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ResourceController {
    @RequestMapping({"/", "/app/about"})
    public String index(){
        return "/app/index";
    }
}
