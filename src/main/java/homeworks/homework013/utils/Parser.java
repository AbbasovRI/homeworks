package homeworks.homework013.utils;

import java.util.function.Function;

public class Parser {

    // Метод для парсинга целого числа
    public static int parseCount(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Неверный формат числа: " + value, e);
        }
    }

    // Метод для парсинга вещественного числа
    public static double parseNumber(String value) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Неверный формат числа: " + value, e);
        }
    }
}
