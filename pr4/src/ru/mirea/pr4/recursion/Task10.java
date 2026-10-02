package ru.mirea.pr4.recursion;

import java.util.Scanner;

/** Задание 10. Разворот числа (только рекурсия и целочисленная арифметика). */
public class Task10 {

    // acc - уже накопленная перевёрнутая часть числа
    static long reverse(long n, long acc) {
        if (n == 0) {
            return acc;
        }
        return reverse(n / 10, acc * 10 + n % 10);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        System.out.println(reverse(n, 0));
    }
}
