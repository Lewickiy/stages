package com.lewickiy.products;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("")
    public String goHomePage() {
        return "index";
    }
}
