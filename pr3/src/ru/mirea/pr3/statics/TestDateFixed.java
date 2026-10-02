package ru.mirea.pr3.statics;

import java.util.Date;

/** Задание 4. Исправленная программа: элементы массива сначала создаются */
public class TestDateFixed {
    public static void main(String[] args) {
        Date[] dates = new Date[10];
        // после new Date[10] в массиве 10 ссылок со значением null - создаем объекты
        for (int i = 0; i < dates.length; i++) {
            dates[i] = new Date();
        }
        System.out.println(dates[0]);
        System.out.println(dates[0].toString());
    }
}
