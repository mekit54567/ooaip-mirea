package ru.mirea.pr4.recursion;

import java.util.Scanner;

/** Задание 9. Последовательности из a нулей и b единиц без двух нулей подряд. */
public class Task09 {

    static long count(int a, int b) {
        if (a == 0) {                  // остались только единицы - один способ
            return 1;
        }
        if (b == 0) {                  // остались только нули - можно поставить лишь один
            return a == 1 ? 1 : 0;
        }
        // последовательность заканчивается либо на "1", либо на "10"
        return count(a, b - 1) + count(a - 1, b - 1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        System.out.println(count(a, b));
    }
}
