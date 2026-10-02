package ru.mirea.dop;

import java.util.GregorianCalendar;

/** Задание № 5. Класс GregorianCalendar. */
public class CalendarDemo {
    public static void main(String[] args) {
        GregorianCalendar calendar = new GregorianCalendar();
        printDate("Текущая дата", calendar);

        calendar.setTimeInMillis(1234567898765L);
        printDate("Дата для 1234567898765 мс", calendar);
    }

    private static void printDate(String title, GregorianCalendar c) {
        // месяц хранится от 0 до 11, поэтому прибавляем 1
        System.out.println(title + ": год " + c.get(GregorianCalendar.YEAR)
                + ", месяц " + (c.get(GregorianCalendar.MONTH) + 1)
                + ", день " + c.get(GregorianCalendar.DAY_OF_MONTH));
    }
}
