package com.barteq.restaurantReservationSystem.service;

import com.barteq.restaurantReservationSystem.entity.Table;
import com.barteq.restaurantReservationSystem.entity.TableAvailable;
import com.barteq.restaurantReservationSystem.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TableServiceImpl implements TableService {
    @Autowired
    TableRepository tableRepository;
    @Override
    public Table findById(int id) {
        Optional<Table> result = tableRepository.findById(id);
        return result.orElse(null);
    }
}
