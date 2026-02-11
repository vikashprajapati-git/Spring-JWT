package com.spring.jwt.repository;

import com.spring.jwt.model.EngineerCred;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EngineerCredRepository extends JpaRepository<EngineerCred, String> {
    public EngineerCred findByeId(String eId);
}
