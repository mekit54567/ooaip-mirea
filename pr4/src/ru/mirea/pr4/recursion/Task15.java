package ru.mirea.pr4.recursion;

import java.util.Scanner;

/** Задание 15. Цифры числа справа налево. */
public class Task15 {

    static void printDigitsReversed(long n) {
        System.out.print(n % 10 + " ");  // сначала младшая цифра
        if (n >= 10) {
            printDigitsReversed(n / 10);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        printDigitsReversed(in.nextLong());
        System.out.println();
    }
}
