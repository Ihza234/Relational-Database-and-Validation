package com.example.demoapi.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "tbl_suppliers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Suplier implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 150, nullable = false)
    private String name;

    @Column(length = 200, nullable = false)
    private String address;
    @Column(length = 100, nullable = false)
    private String email;

    @ManyToMany(mappedBy = "supliers")
    private Set<Product>products;
}
