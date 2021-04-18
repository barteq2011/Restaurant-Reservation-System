package com.barteq.restaurantReservationSystem.service;

import org.springframework.stereotype.Service;

@Service
public interface EmailService {
    void sendConfirmationMessage(String to, String clientName, String numberOfPeople, String tableDescription);
}
