package com.barteq.restaurantReservationSystem.service;

import com.barteq.restaurantReservationSystem.entity.Table;
import org.springframework.stereotype.Service;

public interface TableService {
    Table findById(int id);
}
