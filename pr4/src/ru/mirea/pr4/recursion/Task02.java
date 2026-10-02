package ru.mirea.pr4.recursion;

import java.util.Scanner;

/** Задание 2. Вывести все числа от 1 до n. */
public class Task02 {

    static void print(int n) {
        if (n == 0) {          // базовый случай
            return;
        }
        print(n - 1);          // сначала выводим 1..n-1
        System.out.print(n + " ");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        print(n);
        System.out.println();
    }
}
