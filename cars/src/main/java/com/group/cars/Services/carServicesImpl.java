package com.group.cars.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.group.cars.Entities.Car;
import com.group.cars.Repositories.CarRepository;

@Service
public class carServicesImpl implements carServices {
    @Autowired
    CarRepository carRepository ;

    @Override
    public Car saveCar(Car c) {
        return carRepository.save(c);
    }

    @Override
    public Car updateCar(Car c) {
        return carRepository.save(c);
    }

    @Override
    public void deleteCar(Car c) {
        carRepository.delete(c);
    }

    @Override
    public void deleteCarById(Long id) {
        carRepository.deleteById(id);;
    }

    @Override
    public Car getCar(Long id) {
        return carRepository.getReferenceById(id);
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Page<Car> getAllCarPP(int page, int size) {
        return carRepository.findAll(PageRequest.of(page, size));
    }
    
}
