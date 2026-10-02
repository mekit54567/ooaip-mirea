package ru.mirea.pr4.recursion;

import java.util.Scanner;

/**
 * Задание 7. Разложение на простые множители в порядке неубывания.
 * Делители перебираются только до sqrt(n): O(sqrt(n)) вызовов, из них не более
 * log2(n) вызовов выводят множитель (см. пояснение о сложности в отчёте).
 */
public class Task07 {

    static void factor(long n, long d) {
        if (n == 1) {                 // базовый случай: всё разложили
            return;
        }
        if (d * d > n) {              // оставшееся n - простое число
            System.out.print(n + " ");
            return;
        }
        if (n % d == 0) {
            System.out.print(d + " ");
            factor(n / d, d);         // тот же делитель может войти ещё раз
        } else {
            factor(n, d + 1);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        factor(n, 2);
        System.out.println();
    }
}
