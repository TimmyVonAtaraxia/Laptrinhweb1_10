package vohuutinn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // render templates/login.html
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register"; // render templates/register.html
    }
}
