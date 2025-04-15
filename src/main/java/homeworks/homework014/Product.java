package homeworks.homework014;

public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Название товара не может быть пустым.");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Цена должна быть положительным числом.");
        }

        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return "Продукт: " + getName() + ", цена: " + getPrice();
    }
}