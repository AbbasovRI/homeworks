package repository;

import models.Car;

import java.io.IOException;
import java.util.List;

public interface CarRepository {
    List<Car> findAll() throws IOException;
    Car findById(long id);
    void save(Car car);
    void update(Car car);
    void delete(Long id);
}
