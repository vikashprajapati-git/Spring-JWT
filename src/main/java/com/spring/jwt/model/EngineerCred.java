package com.spring.jwt.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class EngineerCred {

    @Id
    private String eId;

    @Column(length = 64)
    @NotBlank
    @Size(min=6, max = 64)
    private String password;

}
