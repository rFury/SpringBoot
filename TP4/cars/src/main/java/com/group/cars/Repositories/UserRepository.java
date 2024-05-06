package com.group.cars.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group.cars.Entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
