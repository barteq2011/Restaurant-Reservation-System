package com.barteq.restaurantReservationSystem.repository;

import com.barteq.restaurantReservationSystem.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
