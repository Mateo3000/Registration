package com.Mateo3000.Registrationapp.controller;

import com.Mateo3000.Registrationapp.exception.ResourceNotFoundException;
import com.Mateo3000.Registrationapp.model.User;
import com.Mateo3000.Registrationapp.repository.UserRepository;
import com.Mateo3000.Registrationapp.security.CurrentUser;
import com.Mateo3000.Registrationapp.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }
}