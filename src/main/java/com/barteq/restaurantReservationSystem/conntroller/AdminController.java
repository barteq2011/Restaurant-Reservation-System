package com.barteq.restaurantReservationSystem.conntroller;

import com.barteq.restaurantReservationSystem.service.OrderService;
import com.barteq.restaurantReservationSystem.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    OrderService orderService;
    @Autowired
    TableService tableService;

    @GetMapping()
    public String showMainPanel(Model theModel) {
        theModel.addAttribute("orders", orderService.findAll());
        return "admin/main-panel";
    }
    @GetMapping("/tables")
    public String showTablesPanel(Model theModel) {
        theModel.addAttribute("tables", tableService.findAll());
        return "admin/table-panel";
    }
}
