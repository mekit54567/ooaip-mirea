package ru.mirea.pr11;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Задание 2. Сравнение введенной пользователем даты с текущей.
 */
public class DateCompare {
    public static void main(String[] args) {
        SimpleDateFormat fmt = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        fmt.setLenient(false); // 31.02 и т.п. считаются ошибкой
        Scanner in = new Scanner(System.in);
        Date now = new Date();
        System.out.println("Текущая дата и время: " + fmt.format(now));

        while (true) {
            System.out.print("Введите дату в формате дд.мм.гггг чч:мм (пустая строка - выход): ");
            if (!in.hasNextLine()) {
                break;
            }
            String line = in.nextLine().trim();
            if (line.isEmpty()) {
                System.out.println();
                System.out.println("Работа завершена.");
                break;
            }
            if (Boolean.getBoolean("echo.input")) { // ввод из файла - показываем его
                System.out.println(line);
            }
            // сначала проверяем формат записи, затем - существование даты
            if (!line.matches("\\d{2}\\.\\d{2}\\.\\d{4} \\d{2}:\\d{2}")) {
                System.out.println("  Неверный формат даты! Ожидается дд.мм.гггг чч:мм");
                continue;
            }
            try {
                Date user = fmt.parse(line);
                long diffMin = Math.abs(user.getTime() - now.getTime()) / 60000;
                String diff = String.format("%d дн. %d ч. %d мин.",
                        diffMin / 1440, diffMin / 60 % 24, diffMin % 60);
                int cmp = user.compareTo(now);
                if (cmp < 0) {
                    System.out.println("  Введенная дата раньше текущей на " + diff);
                } else if (cmp > 0) {
                    System.out.println("  Введенная дата позже текущей на " + diff);
                } else {
                    System.out.println("  Даты совпадают");
                }
                System.out.println("  before(now) = " + user.before(now) + ", after(now) = " + user.after(now));
            } catch (ParseException e) {
                System.out.println("  Формат верный, но такой даты (времени) не существует!");
            }
        }
    }
}
