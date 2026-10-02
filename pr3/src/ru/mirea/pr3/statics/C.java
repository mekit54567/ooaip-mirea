package ru.mirea.pr3.statics;

/**
 * Задание 3. Исправленная программа.
 * Ошибка 1: из статического main вызывается метод экземпляра method1().
 * Ошибка 2: из статического method2() используется поле экземпляра c.
 * Исправление: создаем объект C в main, а method2() делаем методом экземпляра.
 */
public class C {
    Circle c = new Circle();

    public static void main(String[] args) {
        C obj = new C();
        obj.method1();
    }

    public void method1() {
        method2();
    }

    public void method2() {
        System.out.println("What is area " + c.getArea());
    }
}
