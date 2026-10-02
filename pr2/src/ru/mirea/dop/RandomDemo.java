package ru.mirea.dop;

import java.util.Random;

/** Задание № 4. Класс Random. */
public class RandomDemo {
    public static void main(String[] args) {
        Random random = new Random(1000);
        System.out.println("Первые 50 случайных чисел от 0 до 100 (seed = 1000):");
        for (int i = 1; i <= 50; i++) {
            System.out.printf("%3d", random.nextInt(100));
            System.out.print(i % 10 == 0 ? "\n" : " ");
        }
    }
}
