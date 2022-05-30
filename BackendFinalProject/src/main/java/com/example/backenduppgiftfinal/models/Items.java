package com.example.backenduppgiftfinal.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Items {
    @Id
    @GeneratedValue
    Long id;

    String name;



}
