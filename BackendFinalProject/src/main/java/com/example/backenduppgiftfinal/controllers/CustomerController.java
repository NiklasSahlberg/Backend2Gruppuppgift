package com.example.backenduppgiftfinal.controllers;

import com.example.backenduppgiftfinal.auth.FakeApplicationUserService;
import com.example.backenduppgiftfinal.models.Customers;
import com.example.backenduppgiftfinal.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping()
public class CustomerController {
    FakeApplicationUserService fakeApplicationUserService;

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/sign_up")
    public String addNewUser(@RequestBody Customers customers){
        customerRepository.save(customers);

        return customers.getName() + " is saved";
    }




    @RequestMapping("/customers")
    public Iterable<Customers> getAllCustomers(){
        return customerRepository.findAll();
    }


    @RequestMapping("/:id")
    public Customers getCustomerById(@PathParam("id") long id) { return customerRepository.findById(id).get(); }
}