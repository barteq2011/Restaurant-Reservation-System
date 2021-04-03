package com.barteq.restaurantReservationSystem.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.*;

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
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z]{2,25}\\s[a-zA-Z]{2,25}$")
    private String clientName;
    @Column(name = "email")
    @NotNull
    @Email
    private String email;
    @Column(name = "address", length = 30)
    @NotNull
    @Pattern(regexp = "^[a-zA-Z]{2,20}\\s\\d{1,3}$")
    private String address;
    @Column(name = "city", length = 20)
    @NotNull
    @Length(min = 2, max = 30)
    private String city;
    @Column(name = "zip_code", length = 6)
    @NotNull
    @Pattern(regexp = "^[0-9]{2}-[0-9]{3}$")
    private String zipCode;
    @Column(name = "number_of_people")
    @NotNull
    private int numberOfPeople;
    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            optional = false)
    @JoinColumn(name = "table_id")
    @NotNull
    private com.barteq.restaurantReservationSystem.entity.Table table;
}
