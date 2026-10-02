package ru.mirea.pr3.statics;

import java.util.Random;

/** Домашнее задание 2. Клиент класса StopWatch: время сортировки выбором 100 000 чисел */
public class SelectionSortTiming {

    private static final int SIZE = 100_000;

    public static void main(String[] args) {
        int[] numbers = new int[SIZE];
        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(1_000_000);
        }

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        selectionSort(numbers);
        stopWatch.stop();

        System.out.println("Отсортировано чисел: " + numbers.length);
        System.out.println("Массив упорядочен: " + isSorted(numbers));
        System.out.println("Первые 5 элементов: " + numbers[0] + " " + numbers[1] + " "
                + numbers[2] + " " + numbers[3] + " " + numbers[4]);
        System.out.println("Время сортировки выбором: " + stopWatch.getElapsedTime() + " мс");
    }

    /** Сортировка выбором по возрастанию */
    public static void selectionSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int tmp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = tmp;
            }
        }
    }

    private static boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) {
                return false;
            }
        }
        return true;
    }
}
