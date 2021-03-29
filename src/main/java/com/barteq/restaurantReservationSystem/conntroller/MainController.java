package com.barteq.restaurantReservationSystem.conntroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
    @GetMapping("/main")
    public String showMainPage() {
        return "main";
    }
    @GetMapping("/regulations")
    public String showRegulationsPage() {
        return "regulations";
    }
    @GetMapping("/contact")
    public String showContactPage() {
        return "contact";
    }
    @GetMapping("/about")
    public String showAboutPage() {
        return "about";
    }
}
