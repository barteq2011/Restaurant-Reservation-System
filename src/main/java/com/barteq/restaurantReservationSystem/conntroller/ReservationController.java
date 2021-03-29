package com.barteq.restaurantReservationSystem.conntroller;

import com.barteq.restaurantReservationSystem.entity.Table;
import com.barteq.restaurantReservationSystem.entity.TableAvailable;
import com.barteq.restaurantReservationSystem.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    private TableService tableService;

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
            return "reservation/form";
        }
        theModel.addAttribute("notAvailable", true);
        return "reservation/map";
    }
}
