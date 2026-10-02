package ru.mirea.pr11;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Задание 4. Создание объектов Date и Calendar по данным пользователя:
 * <Год> <Месяц> <Число> <Часы> <Минуты>.
 */
public class DateBuilder {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Calendar calendar = null;
        while (calendar == null) {
            System.out.print("Введите год, месяц, число, часы и минуты через пробел: ");
            if (!in.hasNextLine()) {
                System.out.println("Нет входных данных.");
                return;
            }
            String line = in.nextLine().trim();
            if (Boolean.getBoolean("echo.input")) { // ввод из файла - показываем его
                System.out.println(line);
            }
            try {
                calendar = parse(line);
            } catch (IllegalArgumentException e) {
                System.out.println("  Ошибка: " + e.getMessage());
            }
        }
        Date date = calendar.getTime();

        SimpleDateFormat fmt = new SimpleDateFormat("dd.MM.yyyy HH:mm, EEEE");
        System.out.println("Date.toString():   " + date);
        System.out.println("Date (формат):     " + fmt.format(date));
        System.out.println("Calendar: год = " + calendar.get(Calendar.YEAR)
                + ", месяц = " + (calendar.get(Calendar.MONTH) + 1)
                + ", число = " + calendar.get(Calendar.DAY_OF_MONTH)
                + ", " + calendar.get(Calendar.HOUR_OF_DAY) + ":"
                + String.format("%02d", calendar.get(Calendar.MINUTE)));
        System.out.println("День года: " + calendar.get(Calendar.DAY_OF_YEAR)
                + ", неделя года: " + calendar.get(Calendar.WEEK_OF_YEAR));
        System.out.println("Миллисекунд с 01.01.1970: " + date.getTime());

        calendar.add(Calendar.DAY_OF_MONTH, 7);
        System.out.println("Через 7 дней будет: " + fmt.format(calendar.getTime()));
    }

    /** Разбор и проверка введенной строки; при ошибке - IllegalArgumentException. */
    private static Calendar parse(String line) {
        String[] parts = line.split("\s+");
        if (parts.length != 5) {
            throw new IllegalArgumentException("нужно ввести ровно 5 целых чисел");
        }
        int[] v = new int[5];
        for (int i = 0; i < 5; i++) {
            try {
                v[i] = Integer.parseInt(parts[i]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("\"" + parts[i] + "\" не является целым числом");
            }
        }
        Calendar calendar = new GregorianCalendar(v[0], v[1] - 1, v[2], v[3], v[4]);
        calendar.setLenient(false); // месяц 13, 40-е число и т. п. считаются ошибкой
        try {
            calendar.getTime();     // при setLenient(false) здесь проверяются поля
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("такой даты или времени не существует");
        }
        return calendar;
    }
}
