package ru.mirea.pr3.statics;

/** Класс F из задания 1 */
public class F {
    int i;
    static String s;

    void imethod() {
        System.out.println("  вызван imethod() объекта, i = " + i);
    }

    static void smethod() {
        System.out.println("  вызван статический smethod(), s = " + s);
    }
}
