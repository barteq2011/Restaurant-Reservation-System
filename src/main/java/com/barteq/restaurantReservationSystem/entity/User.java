package com.barteq.restaurantReservationSystem.entity;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String username;
    @NotNull
    private String password;
    private boolean isNonBlocked;
    private boolean isNotExpired;
    private boolean isEnabled;
    private boolean isCredentialsNonExpired;
    private String authority;
}
