package com.example.demoapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplierData {
    @NotEmpty(message = "Nama Wajib diisi")
    private String name;

    @NotEmpty(message = "Address Wwajib diisi")
    private String address;

    @NotEmpty(message = "Email Wajib diisi")
    @Email(message = "Email is not Valid")
    private String email;


}
