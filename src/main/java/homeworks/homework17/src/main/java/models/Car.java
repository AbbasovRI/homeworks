package models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Car {
    private String make;
    private String model;
    private int year;
    private int horsePower;
    private int acceleration;
    private int suspension;
    private int durability;

    /*
    Почему то не сработала аннотация @AllArgsConstructor, поэтому создал конструктор вручную
     */
    // Ручное определение конструктора с семью аргументами
    public Car(String make, String model, int year, int horsePower, int acceleration, int suspension, int durability) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.horsePower = horsePower;
        this.acceleration = acceleration;
        this.suspension = suspension;
        this.durability = durability;
    }
}