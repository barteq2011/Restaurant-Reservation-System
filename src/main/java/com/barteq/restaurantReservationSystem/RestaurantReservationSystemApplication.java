package com.barteq.restaurantReservationSystem;

import com.barteq.restaurantReservationSystem.entity.Order;
import com.barteq.restaurantReservationSystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestaurantReservationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantReservationSystemApplication.class, args);
	}

	@Autowired
	private OrderService orderService;

	public void init() {
		Order order = new Order();

		orderService.save(order);
	}
}
