package com.barteq.restaurantReservationSystem;

import com.barteq.restaurantReservationSystem.entity.Order;
import com.barteq.restaurantReservationSystem.service.OrderService;
import com.barteq.restaurantReservationSystem.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class RestaurantReservationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantReservationSystemApplication.class, args);
	}

	@Autowired
	private OrderService orderService;
	@Autowired
	private TableService tableService;


	@PostConstruct
	public void init() {
		Order order = new Order();
		order.setId(1);
		order.setClientName("Marek Jakubiak");
		order.setEmail("marek@gmail.com");
		order.setAddress("Ludowa 12");
		order.setCity("Kraków");
		order.setZipCode("42-800");
		order.setNumberOfPeople(2);
		order.setTable(tableService.findById(2));
		orderService.save(order);
	}
}
