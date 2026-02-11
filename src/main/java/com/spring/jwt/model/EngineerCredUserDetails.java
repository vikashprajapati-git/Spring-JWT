package com.spring.jwt.model;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class EngineerCredUserDetails implements UserDetails {

    private EngineerCred engineerCred;

    public EngineerCredUserDetails(EngineerCred engineerCred) {
        this.engineerCred = engineerCred;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public @Nullable String getPassword() {
        return engineerCred.getEPassword();
    }

    @Override
    public String getUsername() {
        return engineerCred.getEId();
    }
}
