/*
package com.example.backenduppgiftfinal.controllers;

import com.example.backenduppgiftfinal.models.BuyOrder;
import com.example.backenduppgiftfinal.models.Customers;
import com.example.backenduppgiftfinal.models.Items;
import com.example.backenduppgiftfinal.repositories.CustomerRepository;
import com.example.backenduppgiftfinal.repositories.ItemRepository;
import com.example.backenduppgiftfinal.repositories.OrderRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import java.util.Arrays;
import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc

class ItemControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ItemRepository mockRepository;
    @MockBean
    private CustomerRepository mockRepository2;
    @MockBean
    private OrderRepository mockRepository3;


    @BeforeEach
    public void init()
    {
        Items i1 = new Items();
        Items i2 = new Items();
        Items i3 = new Items();
        i1.setName("kyl");
        i1.setId(1L);
        i2.setName("potatis");
        i2.setId(2L);
        i3.setName("tvättmedel");
        i3.setId(3L);

        when(mockRepository.findById(1L)).thenReturn(Optional.of(i1));
        when(mockRepository.findAll()).thenReturn(Arrays.asList(i1, i2, i3));


        Customers c1 = new Customers();
        Customers c2 = new Customers();
        Customers c3 = new Customers();
        c1.setName("niklas");
        c1.setId(1L);
        c2.setName("piklas");
        c2.setId(2L);
        c3.setName("miklas");
        c3.setId(3L);

        when(mockRepository2.findById(1L)).thenReturn(Optional.of(c1));
        when(mockRepository2.findAll()).thenReturn(Arrays.asList(c1, c2, c3));

        BuyOrder bo1 = new BuyOrder();
        BuyOrder bo2 = new BuyOrder();
        BuyOrder bo3 = new BuyOrder();
        bo1.setCustomer(c1.getId());
        bo2.setCustomer(c2.getId());
        bo3.setCustomer(c3.getId());
        bo1.setItems(i1);
        bo2.setItems(i2);
        bo3.setItems(i3);

    }

    @Test
    void addItem() throws Exception {
        Items items = new Items();
        items.setId(1L);
        items.setName("kyl");
        mvc.perform(MockMvcRequestBuilders.post("/items").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(asJsonString(items)))
                .andExpect(status().isOk()).andExpect(content().string(equalTo("Varan " + items.getName() + " sparad")));
    }

    @Test
    void allItems() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/items").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(content()
                        .json("[{\"id\":1,\"name\":\"kyl\"}," +
                                "{\"id\":2,\"name\":\"potatis\"},"+
                                "{\"id\":3,\"name\":\"tvättmedel\"}]"));
    }

    @Test
    void itemById() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/items/:id?id=1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"name\":\"kyl\",\"id\":1}"));
    }

    @Test
    void buyItems() throws Exception {
        Items i1 = new Items();
        Items i2 = new Items();
        Items i3 = new Items();
        i1.setName("kyl");
        i1.setId(1L);
        i2.setName("potatis");
        i2.setId(2L);
        i3.setName("tvättmedel");
        i3.setId(3L);

        when(mockRepository.findById(1L)).thenReturn(Optional.of(i1));
        when(mockRepository.findAll()).thenReturn(Arrays.asList(i1, i2, i3));

        Customers c1 = new Customers();
        Customers c2 = new Customers();
        Customers c3 = new Customers();
        c1.setName("niklas");
        c1.setId(4L);
        c2.setName("piklas");
        c2.setId(5L);
        c3.setName("miklas");
        c3.setId(6L);

        when(mockRepository2.findById(4L)).thenReturn(Optional.of(c1));
        when(mockRepository2.findAll()).thenReturn(Arrays.asList(c1, c2, c3));

        BuyOrder bo1 = new BuyOrder();
        bo1.setCustomer(c1.getId());
        bo1.setCustomers(c1);
        bo1.setItems(i1);
        bo1.setId(7L);
        bo1.setItem(i1.getId());

        when(mockRepository3.findById(7L)).thenReturn(Optional.of(bo1));
        mvc.perform(MockMvcRequestBuilders.post("/items/buy").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(asJsonString(bo1)))
                .andExpect(status().isOk());
    }
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}*/
