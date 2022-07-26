package it.home.base.base.web.baseWeb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class indexController {
    @RequestMapping(value = "/api")
    public String index() {
        return "index xfgs";
    }
}
