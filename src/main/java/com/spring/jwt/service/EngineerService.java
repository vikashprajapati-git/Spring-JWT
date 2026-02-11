package com.spring.jwt.service;

import com.spring.jwt.model.Engineer;
import com.spring.jwt.repository.EngineerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EngineerService {

    @Autowired
    private EngineerRepository engineerRepository;


    public ResponseEntity<List<Engineer>> getAllEngineers() {
        return new ResponseEntity<>(engineerRepository.findAll(), HttpStatus.OK);
    }


    public ResponseEntity<Engineer> findByEngineerEid(String eId) {
        return new ResponseEntity<>(engineerRepository.findByeId(eId), HttpStatus.OK);
    }


    public ResponseEntity<String> saveEngineer(Engineer engineer) {
        engineerRepository.save(engineer);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

}
