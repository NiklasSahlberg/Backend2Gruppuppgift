package com.example.backenduppgiftfinal.repositories;

import com.example.backenduppgiftfinal.models.Items;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Items,Long> {
}
