package ru.mirea.pr11;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Задание 1. Фамилия разработчика, дата получения и дата сдачи задания.
 * Фамилия передается аргументом командной строки.
 */
public class DeveloperInfo {
    public static void main(String[] args) {
        String developer = args.length > 0 ? args[0] : "Студент";
        SimpleDateFormat fmt = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        // дата выдачи задания задана вручную (месяцы в Calendar нумеруются с 0)
        Date received = new GregorianCalendar(2026, Calendar.SEPTEMBER, 25, 10, 40).getTime();
        // дата сдачи - текущий момент
        Date submitted = new Date();

        System.out.println("Разработчик: " + developer);
        System.out.println("Задание получено: " + fmt.format(received));
        System.out.println("Задание сдано:    " + fmt.format(submitted));
        System.out.println("То же через System.currentTimeMillis(): "
                + fmt.format(new Date(System.currentTimeMillis())));

        long diffMinutes = (submitted.getTime() - received.getTime()) / (60 * 1000);
        System.out.printf("На выполнение ушло: %d дн. %d ч. %d мин.%n",
                diffMinutes / (24 * 60), diffMinutes / 60 % 24, diffMinutes % 60);
    }
}
