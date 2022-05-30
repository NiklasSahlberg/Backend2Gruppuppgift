package com.example.backenduppgiftfinal.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Customers {
    @Id
    @GeneratedValue
    Long id;
    String name;
    String password;

    @JsonIgnore
    @OneToMany(mappedBy = "customers")
    private List<BuyOrder> orders;
}
