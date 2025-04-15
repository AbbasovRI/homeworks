package homeworks.homework014;

import java.io.PrintStream;

public class Person {
    private String name;
    private double money;
    private Product[] products;
    private int productCount;

    public Person(String name, double money) {
        this.name = name;
        this.money = money;
        this.products = new Product[10];
        this.productCount = 0;
    }

    public String getName() {
        return this.name;
    }

    public double getMoney() {
        return this.money;
    }

    public Product[] getProducts() {
        return this.products;
    }

    public void buyProduct(Product product) {
        if (this.money >= product.getPrice()) {
            if (this.productCount < this.products.length) {
                this.products[this.productCount++] = product;
                this.money -= product.getPrice();
            } else {
                System.out.println("Пакет покупателя заполнен!");
            }
        } else {
            PrintStream var10000 = System.out;
            String var10001 = this.getName();
            var10000.println(var10001 + " не может позволить себе " + product.getName());
        }
    }

    public boolean EmptyBasket() {
        return this.productCount == 0;
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        text.append("Покупатель: ").append(getName()).append(", деньги: ").append(getMoney()).append("\n");
        text.append("Продукты:\n");

        for (int i = 0; i < this.productCount; ++i) {
            text.append(this.products[i].getName()).append("\n");
        }

        return text.toString();
    }
}
