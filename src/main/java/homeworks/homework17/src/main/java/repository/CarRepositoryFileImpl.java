package repository;

import models.Car;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CarRepositoryFileImpl implements CarRepository {
    private final String filePath = "/cars.txt";

    public CarRepositoryFileImpl(InputStream inputStream) {
    }

    @Override
    public List<Car> findAll() throws IOException {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            List<Car> cars = new ArrayList<>();
            for (String line : lines) {
                String[] parts = line.split(",");
                cars.add(new Car(parts[0], parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]),
                        Integer.parseInt(parts[4]), Integer.parseInt(parts[5]), Integer.parseInt(parts[6])));
            }
            return cars;
        } catch (IOException e) {
            throw new FileNotFoundException("Файл с данными автомобилей не найден.");
        }
    }


    @Override
    public Car findById(long id) {
        return null;
    }

    @Override
    public void save(Car car) {
    }

    @Override
    public void update(Car car) {
    }

    @Override
    public void delete(Long id) {
    }
}
