package ru.mirea.pr4.exceptions.task7;

import java.util.Scanner;

/**
 * Задание 7, способ 2. Блоки try-catch удалены везде, кроме main();
 * методы, которые пропускают исключение, объявляют throws Exception.
 */
public class ThrowsDemoThrows {

    public void getKey() throws Exception {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Введите ключ: ");
        String key = myScanner.nextLine();
        printDetails(key);
    }

    public void printDetails(String key) throws Exception {
        String message = getDetails(key);
        System.out.println(message);
    }

    private String getDetails(String key) throws Exception {
        if (key.isEmpty()) {
            throw new Exception("Key set to empty string");
        }
        return "data for " + key;
    }

    public static void main(String[] args) {
        try {
            new ThrowsDemoThrows().getKey();
        } catch (Exception e) {
            System.out.println("Исключение обработано в main(): " + e.getMessage());
        }
    }
}
