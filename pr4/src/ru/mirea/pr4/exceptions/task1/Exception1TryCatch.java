package ru.mirea.pr4.exceptions.task1;

/** Задание 1, шаг 3. Деление на ноль с блоком try-catch. */
public class Exception1TryCatch {

    public void exceptionDemo() {
        try {
            System.out.println(2 / 0);
        } catch (ArithmeticException e) {
            System.out.println("Attempted division by zero");
        }
    }

    public static void main(String[] args) {
        Exception1TryCatch demo = new Exception1TryCatch();
        demo.exceptionDemo();
        System.out.println("Программа продолжает работу после catch");
    }
}
