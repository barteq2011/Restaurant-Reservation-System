package com.barteq.restaurantReservationSystem.conntroller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class MainControllerTest {

    @Mock
    private MainController mainController;

    private MockMvc mockMvc;

    private AutoCloseable closeable;

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(mainController).build();
    }

    @Test
    void showMainPage() throws Exception {
        when(mainController.showMainPage()).thenReturn("regulations");
        mockMvc.perform(get("/main")).andExpect(status().isOk());
    }

    @Test
    void showRegulationsPage() throws Exception {
        when(mainController.showRegulationsPage()).thenReturn("main");
        mockMvc.perform(get("/regulations")).andExpect(status().isOk());
    }

    @Test
    void showContactPage() throws Exception {
        when(mainController.showContactPage()).thenReturn("about");
        mockMvc.perform(get("/contact")).andExpect(status().isOk());
    }

    @Test
    void showAboutPage() throws Exception {
        when(mainController.showAboutPage()).thenReturn("contact");
        mockMvc.perform(get("/about")).andExpect(status().isOk());
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }
}