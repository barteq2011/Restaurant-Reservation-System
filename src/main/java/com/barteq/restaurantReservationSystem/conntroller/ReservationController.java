package com.barteq.restaurantReservationSystem.conntroller;

import com.barteq.restaurantReservationSystem.entity.Order;
import com.barteq.restaurantReservationSystem.entity.Table;
import com.barteq.restaurantReservationSystem.entity.TableAvailable;
import com.barteq.restaurantReservationSystem.service.EmailService;
import com.barteq.restaurantReservationSystem.service.OrderService;
import com.barteq.restaurantReservationSystem.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
    private final TableService tableService;
    private final OrderService orderService;
    private final EmailService emailService;

    @Autowired
    public ReservationController(TableService tableService, OrderService orderService, EmailService emailService) {
        this.tableService = tableService;
        this.orderService = orderService;
        this.emailService = emailService;
    }

    @GetMapping("/map")
    public String showMapPage() {
        return "reservation/map";
    }

    @GetMapping("/form/{tableId}")
    public String showReservationForm(@PathVariable("tableId") int id,
                                      Model theModel) {
        Table tableToReserve = tableService.findById(id);
        if (tableToReserve != null && tableToReserve.getAvailable().equals(TableAvailable.AVAILABLE)) {
            Order newOrder = new Order();
            newOrder.setTable(tableToReserve);
            theModel.addAttribute("order", newOrder);
            return "reservation/form";
        }
        theModel.addAttribute("notAvailable", true);
        return "reservation/map";
    }

    @GetMapping("/reserve")
    public String reserve(@ModelAttribute("order") @Valid Order order,
                          BindingResult bindingResult,
                          Model theModel) {
        if (bindingResult.hasErrors()) {
            theModel.addAttribute("error", true);
            return "reservation/form";
        }
        order.getTable().setAvailable(TableAvailable.NOT_AVAILABLE);
        orderService.save(order);
        emailService.sendConfirmationMessage(order.getEmail(),
                order.getClientName(),
                String.valueOf(order.getNumberOfPeople()),
                order.getTable().getDescription());
        return "reservation/thanks";
    }
}
