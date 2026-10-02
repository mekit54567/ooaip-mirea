package ru.mirea.pr4.exceptions.task2;

import java.util.Scanner;

/** Задание 2, шаг 1. Ввод числа без обработки исключений. */
public class Exception2 {

    public void exceptionDemo() {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter an integer ");
        String intString = myScanner.next();
        int i = Integer.parseInt(intString);
        System.out.println(2 / i);
    }

    public static void main(String[] args) {
        new Exception2().exceptionDemo();
    }
}
