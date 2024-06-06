package com.scm.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scm.entities.User;


@Repository
public interface UserRepo extends JpaRepository<User, String>{

    // Custom query methods

    // Custom finder methods
    public Optional<User> findByEmail(String email);

}
