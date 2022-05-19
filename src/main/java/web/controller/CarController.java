package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.List;

@Controller
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars")
    public String getCarListByCount(ModelMap model, @RequestParam(value = "count", required = false) Integer carCount) {
        List<Car> carList;
        if (carCount == null) {
            carList = carService.getCarList();
        } else {
            carList = carService.getListOfCars(carCount);
        }
        model.addAttribute("cars", carList);
        return "cars";
    }
}
