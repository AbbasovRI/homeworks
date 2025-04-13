package homeworks.homework013;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import homeworks.homework013.utils.Parser;
import homeworks.homework013.Person;
import homeworks.homework013.Product;

public class App {
    public App() {}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> persons = new ArrayList<>();
        List<Product> products = new ArrayList<>();

        System.out.print("Введите имя покупателя и количество денежных средств в формате 'Имя = Сумма;', для завершения введите END ");

        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("END")) {
                System.out.print("Введите наименование продукта и его стоимость в формате 'Продукт = Стоимость;' для завершения введите END ");

                while (true) {
                    input = scanner.nextLine();
                    if (input.equalsIgnoreCase("END")) {
                        for (Person person : persons) {
                            for (Product product : products) {
                                if (person.canAfford(product)) {
                                    person.applyDiscount(product);
                                } else {
                                    System.out.println("Недостаточно средств для покупки.");
                                }
                            }
                        }

                        for (Person person : persons) {
                            System.out.println(person);
                        }

                        for (Product product : products) {
                            System.out.println(product);
                        }

                        return;
                    }

                    String[] pairs2 = input.split(";");

                    for (String pair : pairs2) {
                        String[] parts2 = pair.trim().split("=");
                        if (parts2.length == 2) {
                            String productName = parts2[0].trim();
                            double price = 0;

                            try {
                                price = Parser.parseNumber(parts2[1].trim());
                                products.add(new Product(productName, price));
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                }
            }

            String[] pairs = input.split(";");

            for (String pair : pairs) {
                String[] parts = pair.trim().split("=");
                if (parts.length == 2) {
                    String name = parts[0].trim();
                    double money = 0;

                    try {
                        money = Parser.parseNumber(parts[1].trim());
                        persons.add(new Person(name, money));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }
}