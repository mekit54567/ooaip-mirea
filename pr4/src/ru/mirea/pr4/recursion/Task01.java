package ru.mirea.pr4.recursion;

import java.util.Scanner;

/** Задание 1. Треугольная последовательность 1, 2, 2, 3, 3, 3, ... */
public class Task01 {

    // k - текущее число, left - сколько раз его ещё нужно вывести, n - сколько членов осталось
    static void print(int n, int k, int left) {
        if (n == 0) {              // базовый случай: все члены выведены
            System.out.println();
            return;
        }
        if (left == 0) {           // число k выведено k раз - переходим к k + 1
            print(n, k + 1, k + 1);
            return;
        }
        System.out.print(k + " ");
        print(n - 1, k, left - 1); // шаг рекурсии
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        print(n, 1, 1);
    }
}
