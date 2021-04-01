package com.barteq.restaurantReservationSystem.conntroller;

import com.barteq.restaurantReservationSystem.entity.Order;
import com.barteq.restaurantReservationSystem.entity.Table;
import com.barteq.restaurantReservationSystem.entity.TableAvailable;
import com.barteq.restaurantReservationSystem.service.OrderService;
import com.barteq.restaurantReservationSystem.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    private TableService tableService;
    @Autowired
    private OrderService orderService;

    @GetMapping("/map")
    public String showMapPage() {
        return "reservation/map";
    }
    @GetMapping("/form/{tableId}")
    public String showReservationForm(@PathVariable("tableId") int id,
                                      Model theModel) {
        Table tableToReserve = tableService.findById(id);
        if(tableToReserve!=null && tableToReserve.getAvailable().equals(TableAvailable.AVAILABLE)) {
            Order newOrder = new Order();
            newOrder.setTable(tableToReserve);
            theModel.addAttribute("order", newOrder);
            return "reservation/form";
        }
        theModel.addAttribute("notAvailable", true);
        return "reservation/map";
    }
    @GetMapping("/reserve")
    public String reserve(@Validated @ModelAttribute("order") Order order,
                          Model theModel,
                          BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            theModel.addAttribute("error", true);
            return "reservation/form";
        }
        order.getTable().setAvailable(TableAvailable.NOT_AVAILABLE);
        orderService.save(order);
        return "reservation/thanks";
    }
}
