package homeworks.homework10;

public class Main {
    public static void main(String[] args) {
        int[] array = {12, 15, 18, 21, 24};

        // Проверка на четность элемента
        System.out.println("Четные элементы:");
        int[] evenNumbers = Sequence.filter(array, x -> x % 2 == 0);
        printArray(evenNumbers);

        // Проверка, является ли сумма цифр элемента четной
        System.out.println("\nЭлементы с четной суммой цифр:");
        int[] evenSumElements = Sequence.filter(array, x -> Sequence.sumOfDigits(x) % 2 == 0);
        printArray(evenSumElements);
    }

    // Функция для вывода массива
    private static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
