package com.spring.jwt.controller;

import com.spring.jwt.model.EngineerCred;
import com.spring.jwt.repository.EngineerCredRepository;
import com.spring.jwt.service.EngineerCredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EngineerCredController {
    @Autowired
    private EngineerCredService  engineerCredService;

    @PostMapping("/credential")
    public ResponseEntity<String> saveEngineerCred(@RequestBody EngineerCred engineerCred) {
        return engineerCredService.saveEngineerCred(engineerCred);
    }

    @GetMapping("/credentials")
    public ResponseEntity<List<EngineerCred>> findAllEngineerCred() {
        return engineerCredService.findAllEngineerCred();
    }
}
