package ru.mirea.pr6.temperature;

import java.util.Scanner;

public class TemperatureApp {
    /** Абсолютный ноль по шкале Цельсия. */
    private static final double ABSOLUTE_ZERO = -273.15;

    public static void main(String[] args) {
        Convertable[] converters = {new KelvinConverter(), new FahrenheitConverter()};
        Scanner in = new Scanner(System.in);
        System.out.print("Введите температуры в °C через пробел: ");
        if (!in.hasNextLine()) {
            System.out.println("Нет входных данных.");
            return;
        }
        String input = in.nextLine().trim();
        if (Boolean.getBoolean("echo.input")) { // ввод из файла - показываем его
            System.out.println(input);
        }
        if (input.isEmpty()) {
            System.out.println("Температуры не введены.");
            return;
        }
        for (String p : input.split("\s+")) {
            double c;
            try {
                c = Double.parseDouble(p.replace(',', '.'));
            } catch (NumberFormatException e) {
                System.out.println("  \"" + p + "\" - не число, пропущено");
                continue;
            }
            if (c < ABSOLUTE_ZERO) {
                System.out.println("  " + p + " °C - ниже абсолютного нуля, пропущено");
                continue;
            }
            StringBuilder line = new StringBuilder(String.format("%8.2f °C", c));
            for (Convertable conv : converters) {
                line.append(String.format(" = %8.2f %s", conv.convert(c), conv.getScaleName()));
            }
            System.out.println(line);
        }
    }
}
