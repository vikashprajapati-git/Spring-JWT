package com.spring.jwt.service;

import com.spring.jwt.model.EngineerCred;
import com.spring.jwt.model.EngineerCredUserDetails;
import com.spring.jwt.repository.EngineerCredRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class EngineerUserDetailsService implements UserDetailsService {

    @Autowired
    private EngineerCredRepository engineerCredRepository;

    @Override
    public UserDetails loadUserByUsername(String eId) throws UsernameNotFoundException {
        EngineerCred engineerCred= engineerCredRepository.findByeId(eId);
        if(engineerCred == null){
            System.out.println("No User found");
            throw new UsernameNotFoundException("No User Found");
        }
        return new EngineerCredUserDetails(engineerCred);
    }
}
