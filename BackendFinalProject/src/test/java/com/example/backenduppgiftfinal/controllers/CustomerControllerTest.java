//package com.example.backenduppgiftfinal.controllers;
//
//import com.example.backenduppgiftfinal.models.Customers;
//import com.example.backenduppgiftfinal.models.Items;
//import com.example.backenduppgiftfinal.repositories.CustomerRepository;
//import com.example.backenduppgiftfinal.repositories.ItemRepository;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//
//import java.util.Arrays;
//import java.util.Optional;
//
//import static org.hamcrest.Matchers.equalTo;
//
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//class CustomerControllerTest {
//    @Autowired
//    private MockMvc mvc;
//
//    @MockBean
//    private CustomerRepository mockRepository;
//
//    @BeforeEach
//    public void init()
//    {
//        Customers c1 = new Customers();
//        Customers c2 = new Customers();
//
//        c1.setName("Niklas");
//        c1.setId(1L);
//        c2.setName("Panos");
//        c2.setId(2L);
//
//        when(mockRepository.findById(1L)).thenReturn(Optional.of(c1));
//        when(mockRepository.findAll()).thenReturn(Arrays.asList(c1, c2));
//    }
//
//    @Test
//    void addNewUser() throws Exception {
//        Customers customers = new Customers();
//        customers.setName("niklas");
//        customers.setId(1L);
//
//        mvc.perform(MockMvcRequestBuilders.post("/customers").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
//                        .content(asJsonString(customers)))
//                .andExpect(status().isOk()).andExpect(content().string(equalTo(customers.getName()+ " is saved")));
//    }
//
//    @Test
//    void getAllCustomers() throws Exception {
//        mvc.perform(MockMvcRequestBuilders.get("/customers").accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk()).andExpect(content()
//                        .json("[{\"id\":1,\"name\":\"Niklas\"}," +
//                                "{\"id\":2,\"name\":\"Panos\"}]"));
//    }
//
//    @Test
//    void getCustomerById() throws Exception {
//        mvc.perform(MockMvcRequestBuilders.get("/customers/:id?id=1")
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(content().json("{\"id\":1,\"name\":\"Niklas\"}"));
//    }
//
//    public static String asJsonString(final Object obj) {
//        try {
//            return new ObjectMapper().writeValueAsString(obj);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//}