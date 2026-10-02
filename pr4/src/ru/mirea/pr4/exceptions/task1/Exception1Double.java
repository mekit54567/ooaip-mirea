package ru.mirea.pr4.exceptions.task1;

/** Задание 1, шаг 2. Деление на ноль для чисел с плавающей точкой. */
public class Exception1Double {

    public void exceptionDemo() {
        System.out.println(2.0 / 0.0);
        System.out.println(-2.0 / 0.0);
        System.out.println(0.0 / 0.0);
    }

    public static void main(String[] args) {
        Exception1Double demo = new Exception1Double();
        demo.exceptionDemo();
        System.out.println("Программа завершилась нормально");
    }
}
