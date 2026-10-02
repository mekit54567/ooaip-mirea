package ru.mirea.pr7.strings;

import java.util.Scanner;

public class TestStrings {
    // -Decho.input=true: при вводе из файла дублировать введенные значения в вывод
    private static final boolean ECHO = Boolean.getBoolean("echo.input");

    public static void main(String[] args) {
        StringProcessable p = new ProcessStrings();
        Scanner in = new Scanner(System.in);
        System.out.print("Введите строку: ");
        if (!in.hasNextLine()) {
            System.out.println("Нет входных данных.");
            return;
        }
        String s = in.nextLine();
        echo(s);

        char c = 0;
        boolean ok = false;
        while (!ok) {
            System.out.print("Введите символ для подсчета: ");
            if (!in.hasNextLine()) {
                System.out.println("Нет входных данных.");
                return;
            }
            String symbol = in.nextLine();
            echo(symbol);
            if (symbol.isEmpty()) {
                System.out.println("  Ошибка: нужно ввести один символ.");
            } else {
                c = symbol.charAt(0);
                ok = true;
            }
        }

        System.out.println("Строка: \"" + s + "\"");
        System.out.println("Количество символов: " + p.countChars(s));
        System.out.println("Символ '" + c + "' встречается " + p.countChar(s, c) + " раз(а)");
        System.out.println("Символы на нечетных позициях: \"" + p.oddPositions(s) + "\"");
        System.out.println("Инвертированная строка: \"" + p.invert(s) + "\"");
    }

    private static void echo(String value) {
        if (ECHO) {
            System.out.println(value);
        }
    }
}
