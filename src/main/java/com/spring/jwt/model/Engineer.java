package com.spring.jwt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Engineer {
    @Id
    private String eId;
    private String eName;
    private  String eBranch;
    private int eBatch;
}
