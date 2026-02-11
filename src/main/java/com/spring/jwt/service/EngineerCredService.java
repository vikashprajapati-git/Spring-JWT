package com.spring.jwt.service;

import com.spring.jwt.model.EngineerCred;
import com.spring.jwt.repository.EngineerCredRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EngineerCredService {

    @Autowired
    private EngineerCredRepository engineerCredRepository;

    private BCryptPasswordEncoder  encoder = new BCryptPasswordEncoder(12);


    public ResponseEntity<String> saveEngineerCred(EngineerCred engineerCred) {
        engineerCred.setEPassword(encoder.encode(engineerCred.getEPassword()));
        engineerCredRepository.save(engineerCred);
        return new ResponseEntity<>("Success",HttpStatus.CREATED);
    }


    public ResponseEntity<List<EngineerCred>> findAllEngineerCred() {
        return new ResponseEntity<>(engineerCredRepository.findAll(), HttpStatus.OK);
    }
}
