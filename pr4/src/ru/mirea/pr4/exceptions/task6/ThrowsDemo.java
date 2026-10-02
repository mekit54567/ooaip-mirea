package ru.mirea.pr4.exceptions.task6;

/** Задание 6, шаги 1-2. Исключение передаётся из getDetails() в printMessage(). */
public class ThrowsDemo {

    public void printMessage(String key) {
        String message = getDetails(key);
        System.out.println(message);
    }

    public String getDetails(String key) {
        if (key == null) {
            throw new NullPointerException("null key in getDetails");
        }
        return "data for " + key;
    }

    public static void main(String[] args) {
        ThrowsDemo demo = new ThrowsDemo();
        demo.printMessage("user");
        demo.printMessage(null);
    }
}
