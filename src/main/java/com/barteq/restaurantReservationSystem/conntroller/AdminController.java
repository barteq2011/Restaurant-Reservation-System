package com.barteq.restaurantReservationSystem.conntroller;

import com.barteq.restaurantReservationSystem.entity.Order;
import com.barteq.restaurantReservationSystem.entity.Table;
import com.barteq.restaurantReservationSystem.entity.TableAvailable;
import com.barteq.restaurantReservationSystem.service.OrderService;
import com.barteq.restaurantReservationSystem.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final OrderService orderService;
    private final TableService tableService;

    @Autowired
    public AdminController(OrderService orderService, TableService tableService) {
        this.tableService = tableService;
        this.orderService = orderService;
    }

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
    @GetMapping("/orderForm")
    public String showOrderForm(@RequestParam("orderId") int id,
                                Model theModel) {
        Order order = orderService.findById(id);
        theModel.addAttribute("order", order);
        return "admin/order-form";
    }
    @GetMapping("/modifyOrder")
    public String modifyOrder(@ModelAttribute("order") @Valid Order order,
                              BindingResult bindingResult,
                              Model theModel) {
        if(bindingResult.hasErrors()) {
            theModel.addAttribute("error", true);
            return "admin/order-form";
        }
        orderService.save(order);
        return "redirect:/admin";
    }
    @GetMapping("/cancelOrder")
    public String cancelOrder(@RequestParam("orderId") int id) {
        Order order = orderService.findById(id);
        if(order!=null) {
            order.getTable().setAvailable(TableAvailable.AVAILABLE);
            tableService.save(order.getTable());
            orderService.deleteById(id);
        }
        return "redirect:/admin";
    }
}
