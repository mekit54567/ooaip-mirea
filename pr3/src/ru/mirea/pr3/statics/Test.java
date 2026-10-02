package ru.mirea.pr3.statics;

/**
 * Задание 2. Ключевое слово static поставлено там, где это необходимо:
 * main - всегда static; getCount() работает с полем экземпляра count,
 * поэтому НЕ static; factorial() не зависит от состояния объекта - static.
 */
public class Test {
    int count;

    public static void main(String[] args) {
        Test t = new Test();
        t.count = 3;
        System.out.println("getCount() = " + t.getCount());
        for (int n = 0; n <= 6; n++) {
            System.out.println(n + "! = " + Test.factorial(n));
        }
    }

    public int getCount() {
        return count;
    }

    public static int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
