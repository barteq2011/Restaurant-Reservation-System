package com.barteq.restaurantReservationSystem.service;

import com.barteq.restaurantReservationSystem.entity.User;
import com.barteq.restaurantReservationSystem.entity.UserPrincipal;
import com.barteq.restaurantReservationSystem.repository.UserRespository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class UserDetailsServiceTest {

    @Mock
    private UserRespository userRespository;

    @InjectMocks
    private UserDetailsService userDetailsService;

    private AutoCloseable closeable;

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    void loadUserByUsername() {
        User user = new User();
        UserPrincipal userPrincipal = new UserPrincipal(user);
        when(userRespository.findByUsername("testUsername")).thenReturn(user);
        assertEquals(userPrincipal.getUsername(), userDetailsService.loadUserByUsername("testUsername").getUsername());
    }

    @Test
    void wrongLoadUserByUsername() {
        when(userRespository.findByUsername("testUsername")).thenReturn(null);
        Executable userDetailsExec = () -> userDetailsService.loadUserByUsername("testUsername");
        assertThrows(UsernameNotFoundException.class, userDetailsExec);
    }
}