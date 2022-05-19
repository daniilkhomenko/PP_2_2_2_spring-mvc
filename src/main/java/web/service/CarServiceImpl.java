package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final List<Car> carList;

    public CarServiceImpl() {
        this.carList = new ArrayList<>();
        carList.add(new Car("Лада", "баклажан", 123));
        carList.add(new Car("BMW", "red", 234));
        carList.add(new Car("Mercedes", "white", 345));
        carList.add(new Car("Porsche", "blue", 456));
        carList.add(new Car("KIA", "yellow", 567));
    }

    public List<Car> getListOfCars(int carCount) {
        if (carCount >= 5) {
            return this.carList;
        }

        List<Car> newCarList = new ArrayList<>();

        for (int i = 0; i < carCount; i++) {
            newCarList.add(this.carList.get(i));
        }

        return newCarList;
    }

    public List<Car> getCarList() {
        return carList;
    }
}
