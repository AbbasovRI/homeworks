package homeworks.homework10Addition;

public class Main {

    public static void main(String[] args) {
        int[] array = {12, 15, 18, 21, 24};

        System.out.println("Четные элементы:");
        int[] evenNumbers = Sequence.filter(array, x -> x % 2 == 0);
        printArray(evenNumbers);

        System.out.println("\nЭлементы с четной суммой цифр:");
        int[] evenSumElements = Sequence.filter(array, x -> Sequence.sumOfDigits(x) % 2 == 0);
        printArray(evenSumElements);

        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"
        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        boolean mustBeTrue = pair.equals(pair2); // true!
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode();

        System.out.println("i = " + i);
        System.out.println("s = " + s);
        System.out.println("mustBeTrue = " + mustBeTrue);
        System.out.println("mustAlsoBeTrue = " + mustAlsoBeTrue);
    }

    private static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}