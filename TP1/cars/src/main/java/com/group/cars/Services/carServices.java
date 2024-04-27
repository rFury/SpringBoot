package com.group.cars.Services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.group.cars.Entities.Car;

public interface carServices {
    Car saveCar(Car p);
    Car updateCar(Car p);
    void deleteCar(Car p);
    void deleteCarById(Long id);
    Car getCar(Long id);
    List<Car> getAllCars();
    Page<Car> getAllCarPP(int page, int size);
  
}
