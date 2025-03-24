package homeworks.homework10Addition;

import java.util.Arrays;

public class Sequence {

    public static int[] filter(int[] array, ByCondition condition) {
        return Arrays.stream(array)
                .filter(condition::isOk)
                .toArray();
    }

    static int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
