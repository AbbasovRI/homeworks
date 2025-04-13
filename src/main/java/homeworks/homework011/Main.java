package homeworks.homework011;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();

        cars.add(new Car("a123me", "Mercedes", "White", 0, 8_300_000));
        cars.add(new Car("b873of", "Volga", "Black", 0, 673_000));
        cars.add(new Car("w487mn", "Lexus", "Grey", 76_000, 900_000));
        cars.add(new Car("p987hj", "Volga", "Red", 610, 704_340));
        cars.add(new Car("c987ss", "Toyota", "White", 254_000, 761_000));
        cars.add(new Car("o983op", "Toyota", "Black", 698_000, 740_000));
        cars.add(new Car("p146op", "BMW", "White", 271_000, 850_000));
        cars.add(new Car("u893ii", "Toyota", "Purple", 210_900, 440_000));
        cars.add(new Car("l097df", "Toyota", "Black", 108_000, 780_000));
        cars.add(new Car("y876wd", "Toyota", "Black", 160_000, 1_000_000));

        System.out.println("Автомобили в базе:");
        cars.forEach(System.out::println);

        // Реализация всех 4х пунктов
        // Пункт 1: Номера автомобилей по цвету или пробегу
        String colorToFind = "Black";
        long mileageToFind = 0;
        List<String> carNumbersByColorOrMileage = cars.stream()
                .filter(car -> car.getColor().equals(colorToFind) || car.getMileage() == mileageToFind)
                .map(Car::getNumber)
                .collect(Collectors.toList());
        System.out.println("\nНомера автомобилей по цвету или пробегу: " + carNumbersByColorOrMileage);

        // Пункт 2: Уникальные модели авто в ценовом диапазоне
        int minPrice = 700_000;
        int maxPrice = 800_000;
        long uniqueModelsCount = cars.stream()
                .filter(car -> car.getCost() >= minPrice && car.getCost() <= maxPrice)
                .map(Car::getModel)
                .distinct()
                .count();
        System.out.println("\nУникальные автомобили: " + uniqueModelsCount + " шт.");

        // Пункт 3: Цвет автомобиля с минимальной стоимостью
        String cheapestCarColor = cars.stream()
                .min((car1, car2) -> Double.compare(car1.getCost(), car2.getCost()))
                .orElseThrow(NoSuchElementException::new).getColor();
        System.out.println("\nЦвет автомобиля с минимальной стоимостью: " + cheapestCarColor);

        // Пункт 4: Средняя стоимость модели
        String modelToFind = "Toyota";
        double averageCostOfModel = cars.stream()
                .filter(car -> car.getModel().equals(modelToFind))
                .mapToDouble(Car::getCost)
                .average()
                .orElse(Double.NaN);
        System.out.printf("\nСредняя стоимость модели %s: %.2f\n", modelToFind, averageCostOfModel);
    }
}
