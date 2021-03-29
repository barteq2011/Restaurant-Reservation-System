package com.barteq.restaurantReservationSystem.service;

import com.barteq.restaurantReservationSystem.entity.Table;
import com.barteq.restaurantReservationSystem.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TableServiceImpl implements TableService {
    @Autowired
    TableRepository tableRepository;
    @Override
    public Table findById(int id) {

        return tableRepository.findById(id);
    }
}
