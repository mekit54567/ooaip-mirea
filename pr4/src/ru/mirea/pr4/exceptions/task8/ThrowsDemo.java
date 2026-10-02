package ru.mirea.pr4.exceptions.task8;

import java.util.Scanner;

/**
 * Задание 8. getKey() больше не объявляет throws Exception:
 * исключение обрабатывается в нём самом, а пользователь
 * получает ещё одну попытку ввести ключ.
 */
public class ThrowsDemo {

    public void getKey() {
        Scanner myScanner = new Scanner(System.in);
        boolean done = false;
        while (!done) {
            System.out.print("Введите ключ: ");
            if (!myScanner.hasNextLine()) {   // ввод закончился (Ctrl+D / Ctrl+Z) - ключа не будет
                System.out.println();
                System.out.println("Ввод завершён, ключ не получен.");
                return;
            }
            String key = myScanner.nextLine();
            try {
                printDetails(key);
                done = true;
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage() + ". Попробуйте ещё раз.");
            }
        }
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
        new ThrowsDemo().getKey();
    }
}
