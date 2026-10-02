package ru.mirea.pr4.exceptions.task2;

import java.util.Scanner;

/** Задание 2, шаг 3. Обработка исключений NumberFormatException и ArithmeticException. */
public class Exception2TryCatch {

    public void exceptionDemo() {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter an integer ");
        try {
            String intString = myScanner.next();
            int i = Integer.parseInt(intString);
            System.out.println(2 / i);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: введено не целое число (" + e.getMessage() + ")");
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: деление на ноль (" + e.getMessage() + ")");
        }
        System.out.println("Работа метода завершена");
    }

    public static void main(String[] args) {
        new Exception2TryCatch().exceptionDemo();
    }
}
