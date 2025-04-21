package models;

import models.Car;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Garage {
    private List<Car> parkedCars;


    public Garage(List<Car> cars) {
        this.parkedCars = cars;
    }


    public void addCar(Car car) {
        parkedCars.add(car);
    }


    public void removeCar(Car car) {
        parkedCars.remove(car);
    }
}