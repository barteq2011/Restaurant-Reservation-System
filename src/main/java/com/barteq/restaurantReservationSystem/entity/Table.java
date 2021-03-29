package com.barteq.restaurantReservationSystem.entity;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@javax.persistence.Table(name = "Tables")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Table {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private int id;
    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "available")
    private TableAvailable available;
    @Column(name = "description", length = 50)
    private String description;
    @Column(name = "capacity")
    @NotNull
    private int capacity;
}
