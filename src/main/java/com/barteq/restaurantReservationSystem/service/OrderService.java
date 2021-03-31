package com.barteq.restaurantReservationSystem.service;

import com.barteq.restaurantReservationSystem.entity.Order;

import java.util.List;

public interface OrderService {
    void save(Order order);
    List<Order> findAll();
}
