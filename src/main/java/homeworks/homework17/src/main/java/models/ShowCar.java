package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ShowCar extends Car {
    private int stars;

    public ShowCar(String make, String model, int year, int horsePower, int acceleration, int suspension, int durability, int stars) {
        super(make, model, year, horsePower, acceleration, suspension, durability);
        this.stars = stars;
    }
}