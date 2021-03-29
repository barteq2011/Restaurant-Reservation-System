package com.barteq.restaurantReservationSystem.entity;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name = "Orders")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Order {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private int id;
    @Column(name = "client_name", length = 30)
    @NotNull
    private String clientName;
    @Column(name = "email")
    @NotNull
    private String email;
    @Column(name = "address", length = 30)
    @NotNull
    private String address;
    @Column(name = "city", length = 20)
    @NotNull
    private String city;
    @Column(name = "zip_code", length = 6)
    @NotNull
    private String zipCode;
    @Column(name = "number_of_people")
    @NotNull
    private int numberOfPeople;
}
