package com.group.cars.Crtlers;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.group.cars.Entities.Car;
import com.group.cars.Entities.Family_Group;
import com.group.cars.Repositories.FGRepository;
import com.group.cars.Services.carServices;

import jakarta.validation.Valid;

@Controller
public class CarController {

    @Autowired
    carServices carServices;

    @Autowired
    FGRepository fgRepository;

    @ModelAttribute("fields")
    public BindingResult getBindingResult() {
        return new BeanPropertyBindingResult(new Object(), "fields");
    }

    @GetMapping(value = "/")
    public String welcome() {
        return "redirect:/All";
    }

    @RequestMapping("/All")
    public String listeCars(ModelMap modelMap,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size) {
        Page<Car> Cars = carServices.getAllCarPP(page, size);
        modelMap.addAttribute("Cars", Cars.getContent()); // Use getContent() to get the list of cars
        modelMap.addAttribute("pages", new int[Cars.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);

        return "Car/Cars";
    }

    @GetMapping("/showCreate")
    public String showCreateCarForm(ModelMap model) {
        List<Family_Group> FG = fgRepository.findAll();
        model.addAttribute("car", new Car());
        model.addAttribute("FG", FG);
        return "Car/createCar";
    }

    @PostMapping("/saveCar")
    public String saveCar(@ModelAttribute("car") @Valid Car car, BindingResult bindingResult,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size) {
        int currentPage;
        boolean isNew = false;
        if (car.getCarID() == null) {
            isNew = true;
        }
        if (bindingResult.hasErrors()) {
            return "Car/createCar";
        }
        carServices.saveCar(car);
        if (isNew) // ajout
        {
            Page<Car> cars = carServices.getAllCarPP(page, size);
            currentPage = cars.getTotalPages() - 1;
        } else // modif
            currentPage = page;
        return "redirect:/All?page=" + currentPage + "&size=" + size;
    }

    @RequestMapping("/supprimerCar")
    public String supprimerCar(@RequestParam("id") Long id,
            ModelMap modelMap,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size) {
        carServices.deleteCarById(id);
        Page<Car> Cars = carServices.getAllCarPP(size, page);
        modelMap.addAttribute("Cars", Cars);
        modelMap.addAttribute("pages", Cars.getTotalPages());
        modelMap.addAttribute("currentPage", 0);
        return "Car/Cars";
    }

    @RequestMapping("/modifierCar")
    public String editerCar(@RequestParam("id") Long id,
            ModelMap modelMap) {
        List<Family_Group> FG = fgRepository.findAll();
        modelMap.addAttribute("FG", FG);
        Car p = carServices.getCar(id);
        modelMap.addAttribute("car", p);
        return "Car/editerCar";
    }

    @RequestMapping("/updateCar")
    public String updateCar(@ModelAttribute("Car") Car Car,
            ModelMap modelMap) throws ParseException {

        carServices.updateCar(Car);
        List<Car> Cars = carServices.getAllCars();
        modelMap.addAttribute("Cars", Cars);
        return "Car/Cars";
    }

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> requests

                .requestMatchers("/showCreate", "/saveCar").hasAnyAuthority("ADMIN", "AGENT")

                .requestMatchers("/All").hasAnyAuthority("ADMIN", "AGENT", "USER")
                .anyRequest().authenticated())

                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .exceptionHandling((exception) -> exception.accessDeniedPage("/accessDenied"));

        return http.build();
    }

}
