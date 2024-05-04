package com.group.cars;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.group.cars.Entities.Car;
import com.group.cars.Entities.Family_Group;
import com.group.cars.Repositories.CarRepository;
import com.group.cars.Repositories.FGRepository;

@SpringBootTest
class CarsApplicationTests {
/*
	@Autowired
	private CarRepository carRepository;
	@Autowired
	private FGRepository FGRepository;

	@Test
	void contextLoads() {
		Car car = new Car("Jesko", "Koeinegsegg", 3400000, FGRepository.getReferenceById(1L));
		carRepository.save(car);
	}

	@Test
	public void testFindCar() {
		Car C = carRepository.findById(30L).get();
		System.out.println(C);
	}

	@Test
	public void testUpdateCar() {
		Car C = carRepository.findById(30L).get();
		C.setPrice(10);
		carRepository.save(C);
	}

	@Test
	public void testDeleteCar() {
		carRepository.deleteById(30L);
		;
	}

	@Test
	public void testListerTousCars() {
		List<Car> CARS = carRepository.findAll();
		for (Car C : CARS) {
			System.out.println(C);
		}
	}

	@Test
	public void testfindByNomPrix() {
		List<Car> car = carRepository.findByCarModelAndPrice("Jesko", 10.0);
		for (Car p : car) {
			System.out.println(p);
		}
	}

	@Test
	public void testfindByFamily_Group() {
		Family_Group FG = new Family_Group();
		FG.setId(1L);
		List<Car> car = carRepository.findByFamilyGroup(FG);
		for (Car p : car) {
			System.out.println(p);
		}
	}

	@Test
	public void findByCategorieIdCat() {
		List<Car> cars = carRepository.findByFamilyGroupId(1L);
		for (Car p : cars) {
			System.out.println(p);
		}
	}

	@Test
	public void findByOrderByCarModelAscCars(){
		List<Car> cars = carRepository.findByOrderByCarModelAsc();
		for (Car car : cars){
			System.out.println(car);
		}	
	}
*/
}
