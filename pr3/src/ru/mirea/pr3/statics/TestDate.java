package ru.mirea.pr3.statics;

/** Задание 4. Исходная программа: компилируется, но падает во время выполнения */
public class TestDate {
    public static void main(String[] args) {
        java.util.Date[] dates = new java.util.Date[10];
        System.out.println(dates[0]);
        System.out.println(dates[0].toString());
    }
}
