package homeworks.homework014;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void testBuyProductWithSufficientFunds() { // позитивный тест на проверку успешной покупки при достаточном количестве денежных средств
        Person person = new Person("Александр", 1000);
        Product product = new Product("Хлеб", 50);
        person.buyProduct(product);
        assertEquals(950, person.getMoney(), 0.001);
        assertFalse(person.EmptyBasket());
    }

    @Test
    void testInsufficientFunds() { // негативный тест на проверку достаточного количества денежных средств для покупки продукта
        Person person = new Person("Елена", 100);
        Product product = new Product("Виски", 1500);
        person.buyProduct(product);
        assertEquals(100, person.getMoney(), 0.001);
        assertTrue(person.EmptyBasket());
    }

    @Test
    void testFullBasket() { // негативный тест на проверку места в корзине покупателя
        Person person = new Person("Василий", 1000);
        for (int i = 0; i < 10; i++) {
            person.buyProduct(new Product("Сок", 50));
        }
        person.buyProduct(new Product("Газировка", 50));
        assertEquals(500, person.getMoney(), 0.001);
        assertEquals(10, person.getProducts().length);
    }

    @Test
    void testEmptyBasketInitially() { // тест на проверку начальной пустоты корзины покупателя
        Person person = new Person("Марина", 1000);
        assertTrue(person.EmptyBasket());
    }

    @Test
    void testToStringMethod() { // тест на проверку корректности вывода строкового представления объекта
        Person person = new Person("Антон", 1000);
        person.buyProduct(new Product("Кофе", 500));

        String expectedOutput = "Покупатель: Антон, деньги: 500.0\nПродукты:\nКофе";

        assertEquals(expectedOutput, person.toString().trim());
    }

    @Test
    @Disabled("Пока откладываем этот тест")
    void ignoredTest() {
            }
}
