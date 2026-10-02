package ru.mirea.pr3.statics;

/** Исходная программа из задания 3 (содержит ошибки) */
public class C {
    public static void main(String[] args) {
        method1();
    }

    public void method1() {
        method2();
    }

    public static void method2() {
        System.out.println("What is area " + c.getArea());
    }

    Circle c = new Circle();
}
