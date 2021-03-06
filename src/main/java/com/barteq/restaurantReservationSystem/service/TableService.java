package com.barteq.restaurantReservationSystem.service;

import com.barteq.restaurantReservationSystem.entity.Table;

import java.util.List;

public interface TableService {
    Table findById(int id);

    List<Table> findAll();

    void save(Table table);
}
