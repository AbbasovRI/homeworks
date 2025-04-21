package models;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
public class DragRace extends Race {
    public DragRace() {}

    public DragRace(int length, String route, int prizeFund, Collection<Car> participants) {
        super(length, route, prizeFund, participants);
    }
}
