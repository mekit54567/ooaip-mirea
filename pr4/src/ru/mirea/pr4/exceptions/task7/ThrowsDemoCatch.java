package ru.mirea.pr4.exceptions.task7;

import java.util.Scanner;

/**
 * Задание 7, способ 1. Исключение объявлено в getDetails() и
 * обрабатывается блоком try-catch в printDetails().
 */
public class ThrowsDemoCatch {

    public void getKey() {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Введите ключ: ");
        String key = myScanner.nextLine();
        printDetails(key);
    }

    public void printDetails(String key) {
        try {
            String message = getDetails(key);
            System.out.println(message);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private String getDetails(String key) throws Exception {
        if (key.isEmpty()) {
            throw new Exception("Key set to empty string");
        }
        return "data for " + key;
    }

    public static void main(String[] args) {
        new ThrowsDemoCatch().getKey();
    }
}
