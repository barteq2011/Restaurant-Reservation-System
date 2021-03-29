package com.barteq.restaurantReservationSystem.conntroller;

import com.barteq.restaurantReservationSystem.entity.Order;
import com.barteq.restaurantReservationSystem.entity.Table;
import com.barteq.restaurantReservationSystem.entity.TableAvailable;
import com.barteq.restaurantReservationSystem.service.OrderService;
import com.barteq.restaurantReservationSystem.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
            theModel.addAttribute("table", tableToReserve);
            theModel.addAttribute("order", new Order());
            return "reservation/form";
        }
        theModel.addAttribute("notAvailable", true);
        return "reservation/map";
    }
    @GetMapping("/reserve")
    public String reserve(@ModelAttribute("order") Order order,
                          @ModelAttribute("table") Table table) {
        table.setAvailable(TableAvailable.NOT_AVAILABLE);
        tableService.save(table);
        orderService.save(order);
        return "reservation/thanks";
    }
}
