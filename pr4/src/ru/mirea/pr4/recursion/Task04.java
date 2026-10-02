package ru.mirea.pr4.recursion;

import java.util.Scanner;

/** Задание 4. Количество k-значных натуральных чисел с суммой цифр s. */
public class Task04 {

    // k - сколько цифр осталось поставить, s - какая сумма ещё нужна, first - первая ли это позиция
    static long count(int k, int s, boolean first) {
        if (k == 0) {                 // базовый случай: цифры закончились
            return s == 0 ? 1 : 0;
        }
        if (s < 0 || s > 9 * k) {     // отсечение: такую сумму уже не набрать
            return 0;
        }
        long result = 0;
        for (int d = first ? 1 : 0; d <= 9; d++) {   // число не может начинаться с 0
            result += count(k - 1, s - d, false);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int s = in.nextInt();
        System.out.println(count(k, s, true));
    }
}
