package com.example.demoapi.repository;

import com.example.demoapi.model.entities.Suplier;
import org.springframework.data.repository.CrudRepository;

public interface SupplierRepo extends CrudRepository<Suplier, Long> {
}
