package part1;

/**
 * Задание 3. Массив задаётся инициализацией, в цикле for
 * считаются сумма и среднее арифметическое элементов.
 */
public class ArraySum {
    public static void main(String[] args) {
        int[] numbers = {5, 12, -3, 8, 21, 7, 0, 14};

        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        double average = (double) sum / numbers.length;

        System.out.print("Массив: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
        System.out.println("Количество элементов: " + numbers.length);
        System.out.println("Сумма элементов: " + sum);
        System.out.printf("Среднее арифметическое: %.3f%n", average);
    }
}
