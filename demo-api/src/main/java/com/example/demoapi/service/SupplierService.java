package com.example.demoapi.service;

import com.example.demoapi.model.entities.Suplier;
import com.example.demoapi.repository.SupplierRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class SupplierService {

    @Autowired
    private SupplierRepo supplierRepo;

    public Suplier save(Suplier suplier){
        return supplierRepo.save(suplier);
    }
    public Suplier findOne(Long id){
        Optional<Suplier> suplier=supplierRepo.findById(id);
        if (!suplier.isPresent()) {
            return null;
        }
        return suplier.get();
        }

        public Iterable<Suplier>findAll(){
        return supplierRepo.findAll();
    }
    public void removeOne (Long id){
        supplierRepo.deleteById(id);
    }
}
