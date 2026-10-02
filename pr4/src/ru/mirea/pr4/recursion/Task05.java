package ru.mirea.pr4.recursion;

import java.util.Scanner;

/** Задание 5. Сумма цифр числа (без строк, массивов и циклов). */
public class Task05 {

    static int digitSum(long n) {
        if (n < 10) {                       // базовый случай: одна цифра
            return (int) n;
        }
        return (int) (n % 10) + digitSum(n / 10);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        System.out.println(digitSum(n));
    }
}
