package ru.mirea.pr4.recursion;

import java.util.Scanner;

/** Задание 3. Вывести числа от A до B (по возрастанию или по убыванию). */
public class Task03 {

    static void print(int a, int b) {
        System.out.print(a + " ");
        if (a == b) {                         // базовый случай
            return;
        }
        print(a < b ? a + 1 : a - 1, b);      // шаг в сторону B
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        print(a, b);
        System.out.println();
    }
}
