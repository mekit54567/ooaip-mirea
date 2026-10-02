package ru.mirea.pr4.exceptions.task4;

import java.util.Scanner;

/** Задание 4. Решение задания 2 с блоком finally. */
public class Exception4 {

    public void exceptionDemo() {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter an integer ");
        try {
            String intString = myScanner.next();
            int i = Integer.parseInt(intString);
            System.out.println(2 / i);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: введено не целое число");
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: деление на ноль");
        } finally {
            System.out.println("finally: блок выполняется всегда");
        }
    }

    public static void main(String[] args) {
        new Exception4().exceptionDemo();
    }
}
