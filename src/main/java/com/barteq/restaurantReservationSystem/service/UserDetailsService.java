package com.barteq.restaurantReservationSystem.service;

import com.barteq.restaurantReservationSystem.entity.User;
import com.barteq.restaurantReservationSystem.entity.UserPrincipal;
import com.barteq.restaurantReservationSystem.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UserRespository userRespository;

    @Autowired
    public UserDetailsService(UserRespository userRespository) {
        this.userRespository = userRespository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRespository.findByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException(username);
        return new UserPrincipal(user);
    }
}
