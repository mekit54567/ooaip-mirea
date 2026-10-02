package ru.mirea.pr4.recursion;

import java.util.Scanner;

/** Задание 8. Проверка слова на палиндром (без циклов). */
public class Task08 {

    static boolean isPalindrome(String s, int left, int right) {
        if (left >= right) {                          // дошли до середины
            return true;
        }
        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }
        return isPalindrome(s, left + 1, right - 1);  // сужаем отрезок
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String word = in.next();
        System.out.println(isPalindrome(word, 0, word.length() - 1) ? "YES" : "NO");
    }
}
