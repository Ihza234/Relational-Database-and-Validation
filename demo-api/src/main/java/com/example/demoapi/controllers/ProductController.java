package com.example.demoapi.controllers;

import com.example.demoapi.dto.ResponseData;
import com.example.demoapi.model.entities.Product;
import com.example.demoapi.model.entities.Suplier;
import com.example.demoapi.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ResponseData<Product>> create(@Valid @RequestBody Product product, Errors errors) {
        ResponseData<Product> responseData= new ResponseData<>();
        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
               responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayLoad(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayLoad(productService.save(product));

        return ResponseEntity.ok(responseData);
        }


    @GetMapping
    public Iterable<Product>findAll(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findOne(@PathVariable("id")Long id){
        return productService.findOne(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ResponseData<Product>> update(@Valid @RequestBody Product product,Errors errors){
        ResponseData<Product> responseData= new ResponseData<>();
        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayLoad(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayLoad(productService.save(product));

        return ResponseEntity.ok(responseData);
    }
    @DeleteMapping("/{id}")
    public void removeOne(@PathVariable("id")Long id){
         productService.removeOne(id);
    }

    @PostMapping("/{id}")
    public void addSuplier(@RequestBody Suplier suplier, @PathVariable("id") Long productId){
        productService.addSupplier(suplier, productId);
    }
}
