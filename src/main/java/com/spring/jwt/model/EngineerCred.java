package com.spring.jwt.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class EngineerCred {

    @Id
    private String eId;

    @NotBlank
    private String ePassword;

}
