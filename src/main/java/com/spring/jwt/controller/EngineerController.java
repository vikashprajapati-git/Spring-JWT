package com.spring.jwt.controller;

import com.spring.jwt.model.Engineer;
import com.spring.jwt.repository.EngineerRepository;
import com.spring.jwt.service.EngineerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EngineerController {

    @Autowired
    private EngineerService engineerService;

    @GetMapping("/engineers")
    public ResponseEntity<List<Engineer>> getAllEngineer(){
        return engineerService.getAllEngineers();

    }

    @GetMapping("/engineer/{id}")
    public ResponseEntity<Engineer> findByEngineerEid(@PathVariable String id){
        return engineerService.findByEngineerEid(id);
    }

    @PostMapping("/engineer")
    public ResponseEntity<String> addEngineer(@RequestBody Engineer engineer){
        return engineerService.saveEngineer(engineer);
    }

}
