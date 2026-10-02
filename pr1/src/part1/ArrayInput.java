package part1;

import java.util.Scanner;

/**
 * Задание 4. Массив вводится с клавиатуры, сумма считается
 * циклами do-while и while, ищутся максимальный и минимальный элементы.
 */
public class ArrayInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите количество элементов массива: ");
        int n = readInt(sc);
        while (n <= 0) {
            System.out.print("Количество должно быть положительным, повторите ввод: ");
            n = readInt(sc);
        }

        int[] arr = new int[n];
        System.out.println("Введите " + n + " целых чисел:");
        for (int i = 0; i < n; i++) {
            arr[i] = readInt(sc);
        }

        // сумма с помощью цикла do-while
        int sumDoWhile = 0;
        int i = 0;
        do {
            sumDoWhile += arr[i];
            i++;
        } while (i < arr.length);

        // сумма с помощью цикла while
        int sumWhile = 0;
        int j = 0;
        while (j < arr.length) {
            sumWhile += arr[j];
            j++;
        }

        // поиск минимума и максимума
        int min = arr[0];
        int max = arr[0];
        int k = 1;
        while (k < arr.length) {
            if (arr[k] < min) {
                min = arr[k];
            }
            if (arr[k] > max) {
                max = arr[k];
            }
            k++;
        }

        System.out.println();
        System.out.print("Введенный массив: ");
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
        System.out.println("Сумма (цикл do-while): " + sumDoWhile);
        System.out.println("Сумма (цикл while):    " + sumWhile);
        System.out.println("Минимальный элемент:   " + min);
        System.out.println("Максимальный элемент:  " + max);
        sc.close();
    }

    /**
     * Чтение целого числа с проверкой hasNextInt() (как в листинге 1.3):
     * нечисловые лексемы пропускаются с сообщением, при конце ввода
     * программа завершается.
     */
    private static int readInt(Scanner sc) {
        while (sc.hasNext()) {
            if (sc.hasNextInt()) {
                return sc.nextInt();
            }
            String bad = sc.next();
            System.out.print("\"" + bad + "\" - не целое число, повторите ввод: ");
        }
        System.out.println();
        System.out.println("Ввод завершен до получения всех данных, программа остановлена.");
        System.exit(1);
        return 0; // недостижимо
    }
}
