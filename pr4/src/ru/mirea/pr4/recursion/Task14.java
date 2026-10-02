package ru.mirea.pr4.recursion;

import java.util.Scanner;

/** Задание 14. Цифры числа слева направо. */
public class Task14 {

    static void printDigits(long n) {
        if (n >= 10) {
            printDigits(n / 10);     // сначала выводим старшие цифры
        }
        System.out.print(n % 10 + " ");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        printDigits(in.nextLong());
        System.out.println();
    }
}
