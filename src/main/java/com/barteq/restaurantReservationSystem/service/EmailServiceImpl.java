package com.barteq.restaurantReservationSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    public final JavaMailSender javaMailSender;

    @Autowired
    public EmailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendConfirmationMessage(String to, String clientName,
                                        String numberOfPeople,
                                        String tableDescription,
                                        int orderId) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("alterier.romero@gmail.com");
        message.setTo(to);
        message.setSubject("Potwierdzenie rezerwacji w Alterier Romero");
        String messageText = "Dziękujemy za skorzystanie z systemu rezerwacji Alterier Romero\n" +
                "\nSzczegóły zamówienia: \n" +
                "\nImię i nazwisko: " + clientName +
                "\nIlość osób: " + numberOfPeople +
                "\nStolik: " + tableDescription +
                "\n\nNumer zamówienia: " + orderId;
        message.setText(messageText);
        javaMailSender.send(message);
    }
}
