package com.spring.jwt.repository;

import com.spring.jwt.model.Engineer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EngineerRepository extends JpaRepository<Engineer,String> {

    public Engineer findByeId(String eId);
}
