package pl.edu.pw.PRK.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {
    @GetMapping("/")
    public String showHome(){
        return "home";
    }
}
