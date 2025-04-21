package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PerformanceCar extends Car {
    private List<String> addOns;

    public PerformanceCar(String make, String model, int year, int horsePower, int acceleration, int suspension, int durability) {
        super(make, model, year, horsePower, acceleration, suspension, durability);
        addOns = new ArrayList<>();
    }

    public void addAddOn(String addOn) {
        addOns.add(addOn);
    }

    public void removeAddOn(String addOn) {
        addOns.remove(addOn);
    }
}