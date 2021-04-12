package com.barteq.restaurantReservationSystem.repository;

import com.barteq.restaurantReservationSystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRespository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
