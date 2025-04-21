
import models.Car;
import repository.CarRepository;
import repository.CarRepositoryFileImpl;
import models.CasualRace;
import models.Garage;

import java.io.IOException;
import java.util.List;

public class App {
    public static void main(String[] args) {
        try {

            CarRepository repository = new CarRepositoryFileImpl();
            List<Car> cars = repository.findAll();

            List<Car> participants = cars.subList(0, Math.min(3, cars.size()));

            CasualRace casualRace = new CasualRace(10000, "Городской трек", 500000, participants);
            System.out.println("Информация о гонке:");
            System.out.println(casualRace);

            Garage garage = new Garage(participants);
            System.out.println("\nИнформация о гараже:");
            System.out.println(garage);

        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла с автомобилями: " + e.getMessage());
        }
    }
}