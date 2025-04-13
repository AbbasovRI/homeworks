package homeworks.homework013;

import homeworks.homework013.Product;
import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;


    public Person(String name, double money) throws IllegalArgumentException {
        setName(name);  // Добавили проверку имени
        setMoney(money);  // Добавили проверку суммы денег
        this.products = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) throws IllegalArgumentException {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя покупателя не может быть пустой строкой.");
        }
        this.name = name;
    }

    public double getMoney() {
        return this.money;
    }

    public void setMoney(double money) throws IllegalArgumentException {
        if (money < 0) {
            throw new IllegalArgumentException("Деньги не могут быть отрицательными.");
        }
        this.money = money;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public void applyDiscount(Product product) {
        double priceToPay = product.getPrice();

        if (this.money >= priceToPay) {
            this.products.add(product);
            this.money -= priceToPay;
            System.out.println("Покупка совершена. Цена: " + priceToPay);
        } else {
            System.out.println("Недостаточно средств для покупки.");
        }
    }

    public boolean canAfford(Product product) {
        return this.money >= product.getPrice();
    }

    private void updateBalance(Product product) {
        this.money -= product.getPrice();
    }

    private void refund(Product product) {
        this.money += product.getPrice();
    }

    public boolean hasProducts() {
        return !this.products.isEmpty();
    }

    public double calculateTotalCost() {
        double totalCost = 0.0;

        for (Product product : this.products) {
            totalCost += product.getPrice();
        }

        return totalCost;
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        text.append("Покупатель: ").append(getName())
                .append(", деньги: ").append(getMoney()).append("\n")
                .append("Продукты:\n");

        for (Product product : this.products) {
            text.append(product.getName()).append("\n");
        }

        return text.toString();
    }
}
