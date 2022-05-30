package com.example.backenduppgiftfinal.repositories;

import com.example.backenduppgiftfinal.models.Customers;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customers, Long> {
}
