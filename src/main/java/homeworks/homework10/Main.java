package homeworks.homework10;

public class Main {
    public static void main(String[] args) {
        int[] array = {12, 15, 18, 21, 24};

        System.out.println("Четные элементы:");
        int[] evenNumbers = Sequence.filter(array, x -> x % 2 == 0);
        printArray(evenNumbers);

        System.out.println("\nЭлементы с четной суммой цифр:");
        int[] evenSumElements = Sequence.filter(array, x -> Sequence.sumOfDigits(x) % 2 == 0);
        printArray(evenSumElements);
    }

    private static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
