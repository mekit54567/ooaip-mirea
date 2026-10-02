package ru.mirea.pr4.exceptions.task6;

/** Задание 6, шаг 3. Исключение обрабатывается в printMessage(), программа не "ломается". */
public class ThrowsDemoCatch {

    public void printMessage(String key) {
        try {
            String message = getDetails(key);
            System.out.println(message);
        } catch (NullPointerException e) {
            System.out.println("Не удалось получить данные: " + e.getMessage());
        }
    }

    public String getDetails(String key) {
        if (key == null) {
            throw new NullPointerException("null key in getDetails");
        }
        return "data for " + key;
    }

    public static void main(String[] args) {
        ThrowsDemoCatch demo = new ThrowsDemoCatch();
        demo.printMessage("user");
        demo.printMessage(null);
        demo.printMessage("admin");
        System.out.println("Программа завершилась нормально");
    }
}
