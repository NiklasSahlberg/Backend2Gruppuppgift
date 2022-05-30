package com.example.backenduppgiftfinal.repositories;

import com.example.backenduppgiftfinal.models.BuyOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<BuyOrder, Long> {
    List<BuyOrder>findByCustomer (long Customer);
}
