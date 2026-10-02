package ru.mirea.pr4.exceptions.task3;

import java.util.Scanner;

/** Задание 3, шаг 1. Пункт catch (Exception) добавлен в НАЧАЛО списка - не компилируется. */
public class Exception3 {

    public void exceptionDemo() {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter an integer ");
        try {
            String intString = myScanner.next();
            int i = Integer.parseInt(intString);
            System.out.println(2 / i);
        } catch (Exception e) {
            System.out.println("Общее исключение: " + e);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: введено не целое число");
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: деление на ноль");
        }
    }

    public static void main(String[] args) {
        new Exception3().exceptionDemo();
    }
}
