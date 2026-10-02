package ru.mirea.pr4.exceptions.task5;

/** Задание 5, шаг 1. Генерация собственного исключения через throw. */
public class ThrowsDemo {

    public void getDetails(String key) {
        if (key == null) {
            throw new NullPointerException("null key in getDetails");
        }
        System.out.println("Обрабатываем ключ " + key);
    }

    public static void main(String[] args) {
        ThrowsDemo demo = new ThrowsDemo();
        demo.getDetails("user");
        demo.getDetails(null);
    }
}
