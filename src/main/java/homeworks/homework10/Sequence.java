package homeworks.homework10;

import java.util.Arrays;

public class Sequence {

    // Метод фильтра массива по условию
    public static int[] filter(int[] array, ByCondition condition) {
        return Arrays.stream(array)
                .filter(condition::isOk)
                .toArray();
    }

    // Вспомогательная функция для проверки суммы цифр числа
    static int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
