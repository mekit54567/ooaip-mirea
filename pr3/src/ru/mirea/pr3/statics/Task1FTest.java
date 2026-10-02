package ru.mirea.pr3.statics;

/**
 * Задание 1. Проверка, какие из предложений допустимы.
 * Здесь оставлены только допустимые (1, 2, 3, 4, 6, 8),
 * недопустимые (5 и 7) вынесены в файл errors/Task1Invalid.java
 */
@SuppressWarnings("static")
public class Task1FTest {
    public static void main(String[] args) {
        F f = new F();
        f.i = 10;
        F.s = "static text";

        System.out.println("1. f.i = " + f.i);
        System.out.println("2. f.s = " + f.s);          // допустимо, но лучше писать F.s
        System.out.println("3. f.imethod():");
        f.imethod();
        System.out.println("4. f.smethod():");
        f.smethod();                                     // допустимо, но лучше писать F.smethod()
        System.out.println("6. F.s = " + F.s);
        System.out.println("8. F.smethod():");
        F.smethod();
    }
}
