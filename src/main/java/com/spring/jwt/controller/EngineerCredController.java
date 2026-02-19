package com.spring.jwt.controller;

import com.spring.jwt.model.EngineerCred;
import com.spring.jwt.service.EngineerCredService;
import com.spring.jwt.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EngineerCredController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private EngineerCredService  engineerCredService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<String> registerEngineerCred(@RequestBody EngineerCred engineerCred) {
        return engineerCredService.registerEngineerCred(engineerCred);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginEngineerCred(@RequestBody EngineerCred engineerCred) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(engineerCred.getEId(), engineerCred.getEPassword()));
        if(authentication.isAuthenticated()){
            String jwtToken = jwtService.generateToken(engineerCred.getEId());  //authentication.getEId()
            return new ResponseEntity<>(jwtToken, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>("Failure",HttpStatus.UNAUTHORIZED);
    }

    @GetMapping("/registrations")
    public ResponseEntity<List<EngineerCred>> getAllEngineerCred() {
        return engineerCredService.getAllEngineerCred();
    }
}
