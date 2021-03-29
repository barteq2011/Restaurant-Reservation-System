package com.barteq.restaurantReservationSystem.repository;

import com.barteq.restaurantReservationSystem.entity.Table;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepository extends JpaRepository<Table, Integer> {
}
