package com.example.backenduppgiftfinal.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class BuyOrder {
    @Id
    @GeneratedValue
    private Long id;
    private Long item;
    private Long customer;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn
    Customers customers;

    @ManyToOne
    @JoinColumn
    private Items items;
}
