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
        Table testTable = new Table();
        testTable.setId(0);
        testTable.setAvailable(TableAvailable.AVAILABLE);
        testTable.setCapacity(4);
        testTable.setDescription("Description");
        tableRepository.save(testTable);
        Optional<Table> result = tableRepository.findById(testTable.getId());
        return result.orElse(null);
    }
}
