package com.barteq.restaurantReservationSystem;

import com.barteq.restaurantReservationSystem.entity.Order;
import com.barteq.restaurantReservationSystem.entity.User;
import com.barteq.restaurantReservationSystem.repository.UserRespository;
import com.barteq.restaurantReservationSystem.service.OrderService;
import com.barteq.restaurantReservationSystem.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class RestaurantReservationSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestaurantReservationSystemApplication.class, args);
    }

    @Autowired
    private OrderService orderService;
    @Autowired
    private TableService tableService;
    @Autowired
    private UserRespository userRespository;


    // Test user with test order
    @PostConstruct
    public void init() {
        Order order = new Order();
        order.setId(1);
        order.setClientName("Marek Jakubiak");
        order.setEmail("marek@gmail.com");
        order.setAddress("Ludowa 12");
        order.setCity("Kraków");
        order.setZipCode("42-800");
        order.setNumberOfPeople(2);
        order.setTable(tableService.findById(2));
        orderService.save(order);
        User admin = new User();
        admin.setId(Integer.toUnsignedLong(1));
        admin.setUsername("admin");
        admin.setPassword("$2y$12$f8JojEU14QJGvGgyx3Mtt.XuWYkIo8YUTfavhpClML2uNAm2EPXD.");
        admin.setEnabled(true);
        admin.setCredentialsNonExpired(true);
        admin.setNonBlocked(true);
        admin.setNotExpired(true);
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ADMIN");
        admin.setAuthority(authority);
        userRespository.save(admin);
    }
}
