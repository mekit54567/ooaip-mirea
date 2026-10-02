package ru.mirea.dop;

import java.util.Date;

/** Задание № 3. Класс Date. */
public class DateDemo {
    public static void main(String[] args) {
        Date date = new Date();
        long elapsed = 10000;
        for (int i = 0; i < 8; i++) {
            date.setTime(elapsed);
            System.out.printf("%,16d мс -> %s%n", elapsed, date);
            elapsed *= 10;
        }
    }
}
