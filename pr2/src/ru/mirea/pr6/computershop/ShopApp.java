package ru.mirea.pr6.computershop;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/** Консольное меню магазина. */
public class ShopApp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Shop shop = new Shop("КомпьютерМир");
        ComputerReader reader = new ConsoleComputerReader(in);

        while (true) {
            System.out.println();
            System.out.println("1 - добавить компьютер, 2 - список, 3 - удалить, 4 - поиск, 0 - выход");
            System.out.print("Выберите действие: ");
            if (!in.hasNextLine()) {
                break;
            }
            String choice = ConsoleComputerReader.readLine(in);
            try {
                switch (choice) {
                    case "1":
                        shop.addComputer(reader.readComputer());
                        System.out.println("Компьютер добавлен.");
                        break;
                    case "2":
                        shop.printAll();
                        break;
                    case "3":
                        System.out.print("Номер компьютера для удаления: ");
                        Computer removed = shop.removeComputer(Integer.parseInt(ConsoleComputerReader.readLine(in)));
                        System.out.println(removed == null ? "Нет такого номера." : "Удален: " + removed);
                        break;
                    case "4":
                        System.out.print("Марка (или - для любой): ");
                        String b = ConsoleComputerReader.readLine(in);
                        Brand brand = b.equals("-") ? null : Brand.fromString(b);
                        System.out.print("Минимальный объем ОЗУ, ГБ: ");
                        int ram = Integer.parseInt(ConsoleComputerReader.readLine(in));
                        System.out.print("Максимальная цена, руб.: ");
                        double price = Double.parseDouble(ConsoleComputerReader.readLine(in));
                        List<Computer> found = shop.find(brand, ram, price);
                        System.out.println("Найдено: " + found.size());
                        for (Computer c : found) {
                            System.out.println("  " + c);
                        }
                        break;
                    case "0":
                        System.out.println("До свидания!");
                        return;
                    default:
                        System.out.println("Неизвестная команда.");
                }
            } catch (IllegalArgumentException e) {
                // NumberFormatException тоже является IllegalArgumentException
                System.out.println("Ошибка ввода: " + e.getMessage());
            } catch (NoSuchElementException e) {
                // входные данные закончились посреди операции
                System.out.println();
                System.out.println("Ввод завершен, работа программы прекращена.");
                return;
            }
        }
    }
}
