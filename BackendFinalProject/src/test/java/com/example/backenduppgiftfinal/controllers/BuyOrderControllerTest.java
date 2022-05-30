/*package com.example.backenduppgiftfinal.controllers;

import com.example.backenduppgiftfinal.models.BuyOrder;
import com.example.backenduppgiftfinal.models.Customers;
import com.example.backenduppgiftfinal.models.Items;
import com.example.backenduppgiftfinal.repositories.OrderRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BuyOrderControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private OrderRepository mockRepository;

    @BeforeEach
    public void init() {
        BuyOrder bo1 = new BuyOrder();
        BuyOrder bo2 = new BuyOrder();

        Items items1 = new Items();
        items1.setId(1L);
        items1.setName("frys");

        Items items2 = new Items();
        items2.setId(2L);
        items2.setName("gaffel");

        Customers customers1 = new Customers();
        customers1.setId(1L);
        customers1.setName("niklas");

        Customers customers2 = new Customers();
        customers2.setId(2L);
        customers2.setName("panos");

        bo1.setCustomer(customers1.getId());
        bo1.setItem(items1.getId());
        bo1.setId(1L);

        bo2.setCustomer(customers2.getId());
        bo2.setItem(items2.getId());
        bo2.setId(2L);

        when(mockRepository.findById(1L)).thenReturn(Optional.of(bo1));
        when(mockRepository.findAll()).thenReturn(Arrays.asList(bo1, bo2));
    }


    @Test
    void allOrders() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/orders").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(MockMvcResultMatchers.content().json
                ("[{\"customer\":1,\"item\": 1}," +
                        "{\"customer\":2,\"item\": 2}]"));
  }

    @Test
    void orderById() throws Exception {
        BuyOrder bo1 = new BuyOrder();

        Items items1 = new Items();
        items1.setId(1L);
        items1.setName("frys");

        Customers customers1 = new Customers();
        customers1.setId(1L);
        customers1.setName("niklas");

        bo1.setCustomer(customers1.getId());
        bo1.setItem(items1.getId());
        bo1.setId(1L);

        when(mockRepository.findByCustomer(1L)).thenReturn(List.of(bo1));
        mvc.perform(MockMvcRequestBuilders.get("/orders/:customerId?id=1")
                        .accept(MediaType.APPLICATION_JSON)).andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .json("[{\"id\":1,\"item\":1,\"customer\":1,\"customers\":null,\"items\":null}]"));
    }
}


 */