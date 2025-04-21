package models;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
public abstract class Race {
    protected int length;
    protected String route;
    protected int prizeFund;
    protected Collection<Car> participants;

    // Конструкторы оставлены простыми для демонстрации возможностей Lombok
    public Race() {}

    public Race(int length, String route, int prizeFund, Collection<Car> participants) {
        this.length = length;
        this.route = route;
        this.prizeFund = prizeFund;
        this.participants = participants;
    }
}
