package com.group.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.group.cars.Entities.Car;
import com.group.cars.Repositories.CarRepository;
import com.group.cars.Repositories.FGRepository;

@SpringBootApplication
public class CarsApplication{
	@Autowired
	CarRepository carRepository;
	@Autowired
	FGRepository FGRepository;

	public static void main(String[] args) {
		SpringApplication.run(CarsApplication.class, args);
	}

}
