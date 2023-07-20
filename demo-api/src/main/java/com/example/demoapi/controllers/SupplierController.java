package com.example.demoapi.controllers;

import com.example.demoapi.dto.ResponseData;
import com.example.demoapi.dto.SupplierData;
import com.example.demoapi.model.entities.Suplier;
import com.example.demoapi.service.SupplierService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<ResponseData<Suplier>> create(@Valid @RequestBody SupplierData supplierData, Errors errors) {
        ResponseData<Suplier> responseData = new ResponseData<>();
        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()){
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayLoad(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);

        }
        Suplier suplier= modelMapper.map(supplierData, Suplier.class);

        responseData.setStatus(true);
        responseData.setPayLoad(supplierService.save(suplier));
        return ResponseEntity.ok(responseData);
    }

    @GetMapping
    public Iterable<Suplier> findAll(){
        return supplierService.findAll();
    }

    @GetMapping("/{id}")
    public Suplier findOne(@PathVariable("id")Long id){
        return supplierService.findOne(id);
    }

    @PutMapping
    public ResponseEntity<ResponseData<Suplier>> update(@Valid @RequestBody SupplierData supplierData, Errors errors) {
        ResponseData<Suplier> responseData = new ResponseData<>();
        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()){
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayLoad(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);

        }
        Suplier suplier= modelMapper.map(supplierData, Suplier.class);

        responseData.setStatus(true);
        responseData.setPayLoad(supplierService.save(suplier));
        return ResponseEntity.ok(responseData);
    }

}
