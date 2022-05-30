package com.example.backenduppgiftfinal.controllers;


import com.example.backenduppgiftfinal.models.BuyOrder;
import com.example.backenduppgiftfinal.models.Customers;
import com.example.backenduppgiftfinal.models.Items;
import com.example.backenduppgiftfinal.rabbitMQ.CustomMessage;
import com.example.backenduppgiftfinal.rabbitMQ.MQConfig;
import com.example.backenduppgiftfinal.repositories.CustomerRepository;
import com.example.backenduppgiftfinal.repositories.ItemRepository;
import com.example.backenduppgiftfinal.repositories.OrderRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.UUID;


@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private RabbitTemplate template;
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    OrderRepository orderRepository;

    @PostMapping()
    public String addItem(@RequestBody Items items) {
        itemRepository.save(items);
        return "Varan " + items.getName() + " sparad";
    }

    @RequestMapping()
    public Iterable<Items> allItems()
    {
        return itemRepository.findAll();
    }

    @RequestMapping ("/:id")
    public Items itemById(@PathParam("id") long id) { return itemRepository.findById(id).get(); }

    @PostMapping("/buy") public String buyItems(@RequestBody BuyOrder bo)
    {
        bo.setCustomer(bo.getCustomer());
        Customers c = customerRepository.findById(bo.getCustomer()).get();
        Items i = itemRepository.findById(bo.getItem()).get();

        if (c != null) {
            bo.setCustomers(c);
        }
        if (i != null) {
            bo.setItems(i);
        }
        if (i != null) {
            bo.setItems(i);
        }
        orderRepository.save(bo);
        publishMessage();
        return "order sparad";
    }

    public String publishMessage() {
        CustomMessage message = new CustomMessage();
        message.setMessage("Du har lyckats med ditt köp");
        message.setMessageId(UUID.randomUUID().toString());
        message.setMessageDate(new Date());
        template.convertAndSend(MQConfig.EXCHANGE,
                MQConfig.ROUTING_KEY, message);

        return "Message Published";
    }


}