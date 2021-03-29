package com.barteq.restaurantReservationSystem.conntroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
    @GetMapping("/map")
    public String showMapPage() {
        return "reservation/map";
    }
    @GetMapping("/form/{tableId}")
    public String showReservationForm(@PathVariable("tableId") int id,
                                      Model theModel) {

        return "reservation/form";
    }
}
