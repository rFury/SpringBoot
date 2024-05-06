package com.group.cars.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group.cars.Entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRole(String role);
    }
    
