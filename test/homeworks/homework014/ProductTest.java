package homeworks.homework014;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class ProductTest {

    @Test
    void testCreateAndGetFields() { // проверкана правильность создания объекта и возвращения его полей
        Product product = new Product("Молоко", 50);
        assertEquals("Молоко", product.getName());
        assertEquals(50, product.getPrice(), 0.001);
    }

    @Test
    void testToStringMethod() { // проверка на корректную строку
        Product product = new Product("Колбаса", 200);
        String expectedOutput = "Продукт: Колбаса, цена: 200.0";
        assertEquals(expectedOutput, product.toString());
    }

    @Test // тест на проверку отрицательной цены
    void testNegativePriceException() {
        try {
            new Product("Неверный продукт", -50); // пытаемся создать продукт с отрицательной ценой
            fail("Должно было вызвать исключение IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Цена должна быть положительным числом.", e.getMessage());
        }
    }

    @Test // тест на проверку названия товара
    void testEmptyProductNameException() {
        try {
            new Product("", 50); // создаем продукт с пустым именем
            fail("Должно было вызвать исключение IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Название товара не может быть пустым.", e.getMessage());
        }
    }
}
