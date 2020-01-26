package com.Mateo3000.Registrationapp.repository;

import com.Mateo3000.Registrationapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {

    Optional<User> findByEmail(String email);

    Boolean existsByEmail(String email);

}