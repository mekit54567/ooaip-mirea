package ru.mirea.pr4.exceptions.task1;

/** Задание 1, шаг 1. Целочисленное деление на ноль без обработки исключения. */
public class Exception1 {

    public void exceptionDemo() {
        System.out.println(2 / 0);
    }

    public static void main(String[] args) {
        Exception1 demo = new Exception1();
        demo.exceptionDemo();
        System.out.println("Эта строка не будет выведена");
    }
}
