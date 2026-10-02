package ru.mirea.pr4.exceptions.task5;

/** Задание 5, шаг 2. Исключение перехватывается внутри того же метода. */
public class ThrowsDemoCatch {

    public void getDetails(String key) {
        try {
            if (key == null) {
                throw new NullPointerException("null key in getDetails");
            }
            System.out.println("Обрабатываем ключ " + key);
        } catch (NullPointerException e) {
            System.out.println("Перехвачено внутри getDetails: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        ThrowsDemoCatch demo = new ThrowsDemoCatch();
        demo.getDetails("user");
        demo.getDetails(null);
        System.out.println("Программа завершилась нормально");
    }
}
