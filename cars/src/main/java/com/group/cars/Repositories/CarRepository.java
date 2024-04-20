package com.group.cars.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group.cars.Entities.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
    
}
