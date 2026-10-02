package ru.mirea.pr4.recursion;

import java.util.Scanner;

/**
 * Задание 6. Проверка числа на простоту (рекурсия по делителю).
 * Перебор делителей от 2 до sqrt(n): O(sqrt(n)) вызовов. Оценка O(log n) из условия
 * для проверки простоты перебором делителей недостижима (см. пояснение в отчёте).
 */
public class Task06 {

    static boolean isPrime(long n, long d) {
        if (d * d > n) {          // делителей до корня из n не нашлось
            return true;
        }
        if (n % d == 0) {         // нашли делитель - число составное
            return false;
        }
        return isPrime(n, d + 1); // проверяем следующий делитель
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        System.out.println(isPrime(n, 2) ? "YES" : "NO");
    }
}
