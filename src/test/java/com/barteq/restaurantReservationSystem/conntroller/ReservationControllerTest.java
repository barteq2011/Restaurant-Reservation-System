package com.barteq.restaurantReservationSystem.conntroller;

import com.barteq.restaurantReservationSystem.entity.Order;
import com.barteq.restaurantReservationSystem.entity.Table;
import com.barteq.restaurantReservationSystem.entity.TableAvailable;
import com.barteq.restaurantReservationSystem.service.EmailService;
import com.barteq.restaurantReservationSystem.service.OrderService;
import com.barteq.restaurantReservationSystem.service.TableService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ReservationControllerTest {

    @Mock
    private OrderService orderService;
    @Mock
    private TableService tableService;
    @Mock
    private EmailService emailService;
    @InjectMocks
    private ReservationController reservationController;

    private MockMvc mockMvc;
    private AutoCloseable closeable;

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(reservationController).build();
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    void showMapPage() throws Exception {
        mockMvc.perform(get("/reservation/map")).andExpect(status().isOk());
    }

    @Test
    void showReservationForm() throws Exception {
        Table tableToReserve = new Table();
        tableToReserve.setAvailable(TableAvailable.AVAILABLE);
        when(tableService.findById(1)).thenReturn(tableToReserve);

        mockMvc.perform(get("/reservation/form/1"))
                .andExpect(model().attribute("order", notNullValue()))
                .andExpect(status().isOk());

        tableToReserve.setAvailable(TableAvailable.NOT_AVAILABLE);
        mockMvc.perform(get("/reservation/form/1"))
                .andExpect(model().attribute("notAvailable", true))
                .andExpect(status().isOk());
    }

    @Test
    void reserve() throws Exception {
        Order order = new Order();
        order.setId(1);
        order.setClientName("Marek Jakubiak");
        order.setEmail("marek@gmail.com");
        order.setAddress("Ludowa 12");
        order.setCity("Kraków");
        order.setNumberOfPeople(2);
        Table orderTable = new Table();
        orderTable.setId(1);
        orderTable.setAvailable(TableAvailable.AVAILABLE);
        orderTable.setDescription("Test description");
        orderTable.setCapacity(4);
        order.setTable(orderTable);
        order.setZipCode("42-800");

        mockMvc.perform(get("/reservation/reserve").flashAttr("order", order))
                .andExpect(model().attribute("error", nullValue()))
                .andExpect(status().isOk());
    }

    @Test
    void wrongReserve() throws Exception {
        mockMvc.perform(get("/reservation/reserve").flashAttr("order", new Order()))
                .andExpect(model().attribute("error", true))
                .andExpect(status().isOk());
    }
}