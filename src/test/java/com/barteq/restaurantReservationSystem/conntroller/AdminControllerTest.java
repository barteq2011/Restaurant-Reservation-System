package com.barteq.restaurantReservationSystem.conntroller;

import com.barteq.restaurantReservationSystem.entity.Order;
import com.barteq.restaurantReservationSystem.entity.Table;
import com.barteq.restaurantReservationSystem.entity.TableAvailable;
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

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class AdminControllerTest {

    @Mock
    private OrderService orderService;
    @Mock
    private TableService tableService;

    @InjectMocks
    private AdminController adminController;

    private MockMvc mockMvc;

    private AutoCloseable closeable;

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(adminController).build();
    }

    @Test
    void showMainPanel() throws Exception {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order());
        orders.add(new Order());
        when(orderService.findAll()).thenReturn(orders);

        mockMvc.perform(get("/admin"))
                .andExpect(status().isOk())
                .andExpect(view().name("admin/main-panel"))
                .andExpect(model().attribute("orders", hasSize(2)));
    }

    @Test
    void showTablesPanel() throws Exception {
        List<Table> tables = new ArrayList<>();
        tables.add(new Table());
        tables.add(new Table());
        when(tableService.findAll()).thenReturn(tables);

        mockMvc.perform(get("/admin/tables"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("tables", hasSize(2)));
    }

    @Test
    void showOrderForm() throws Exception {
        Order order = new Order();
        when(orderService.findById(1)).thenReturn(order);

        mockMvc.perform(get("/admin/orderForm").param("orderId", "1"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("order", order));
    }

    @Test
    void modifyOrder() throws Exception {
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

        mockMvc.perform(get("/admin/modifyOrder").flashAttr("order", order))
                .andExpect(model().attribute("error", nullValue()))
                .andExpect(status().isFound());
    }

    @Test
    void wrongModifyOrder() throws Exception {
        mockMvc.perform(get("/admin/modifyOrder").sessionAttr("order", new Order()))
                .andExpect(model().attribute("error", true))
                .andExpect(status().isOk());
    }

    @Test
    void cancelOrder() throws Exception {
        Order order = new Order();
        Table orderTable = new Table();
        order.setTable(orderTable);
        when(orderService.findById(1)).thenReturn(order);

        mockMvc.perform(get("/admin/cancelOrder").param("orderId", "1"))
                .andExpect(status().isFound());
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }
}