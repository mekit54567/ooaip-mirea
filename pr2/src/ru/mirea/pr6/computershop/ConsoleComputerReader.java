package ru.mirea.pr6.computershop;

import java.util.NoSuchElementException;
import java.util.Scanner;

/** Чтение данных компьютера с клавиатуры. */
public class ConsoleComputerReader implements ComputerReader {
    private final Scanner in;

    public ConsoleComputerReader(Scanner in) {
        this.in = in;
    }

    /** Признак дублирования ввода: задается при запуске ключом -Decho.input=true. */
    private static final boolean ECHO = Boolean.getBoolean("echo.input");

    /**
     * Чтение строки. Если ввод перенаправлен из файла и задан ключ -Decho.input=true,
     * введенное значение дублируется на экран, чтобы протокол был читаемым.
     * При окончании ввода выбрасывается NoSuchElementException.
     */
    public static String readLine(Scanner in) {
        if (!in.hasNextLine()) {
            throw new NoSuchElementException("ввод завершен");
        }
        String line = in.nextLine().trim();
        if (ECHO) {
            System.out.println(line);
        }
        return line;
    }

    private String ask(String prompt) {
        System.out.print(prompt);
        return readLine(in);
    }

    @Override
    public Computer readComputer() {
        Brand brand = Brand.fromString(ask("  Марка (Apple, ASUS, Lenovo, HP, Dell, Acer, MSI): "));
        String model = ask("  Модель: ");
        String cpuModel = ask("  Процессор: ");
        int cores = Integer.parseInt(ask("  Количество ядер: "));
        double freq = Double.parseDouble(ask("  Частота, ГГц: "));
        int ram = Integer.parseInt(ask("  Объем ОЗУ, ГБ: "));
        String ramType = ask("  Тип ОЗУ: ");
        double diagonal = Double.parseDouble(ask("  Диагональ монитора: "));
        String resolution = ask("  Разрешение: ");
        double price = Double.parseDouble(ask("  Цена, руб.: "));
        return new Computer(brand, model, new Processor(cpuModel, cores, freq),
                new Memory(ram, ramType), new Monitor(diagonal, resolution), price);
    }
}
