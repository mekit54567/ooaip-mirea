package ru.mirea.pr4.exceptions.task7;

import java.util.Scanner;

/** Задание 7. getDetails() объявляет throws Exception, но printDetails() пробрасывает e дальше без throws. */
public class ThrowsDemoRethrow {

    public void getKey() {
        Scanner myScanner = new Scanner(System.in);
        String key = myScanner.next();
        printDetails(key);
    }

    public void printDetails(String key) {
        try {
            String message = getDetails(key);
            System.out.println(message);
        } catch (Exception e) {
            throw e;
        }
    }

    private String getDetails(String key) throws Exception {
        if (key == "") {
            throw new Exception("Key set to empty string");
        }
        return "data for " + key;
    }
}
