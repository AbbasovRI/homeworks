package homeworks.homework011;

public class Car {

    private String number;
    private String model;
    private String color;
    private long mileage;
    private double cost;


    public Car(String number, String model, String color, long mileage, double cost) {
        this.number = number;
        this.model = model;
        this.color = color;
        this.mileage = mileage;
        this.cost = cost;
    }


    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public long getMileage() { return mileage; }
    public void setMileage(long mileage) { this.mileage = mileage; }

    public double getCost() { return cost; }
    public void setCost(double cost) { this.cost = cost; }


    @Override
    public String toString() {
        return String.format("Number: %s, Model: %s, Color: %s, Mileage: %d, Cost: %.2f",
                number, model, color, mileage, cost);
    }
}