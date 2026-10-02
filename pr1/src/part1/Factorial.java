package part1;

/**
 * Задание 7. Вычисление факториала с помощью метода класса (цикл for)
 * и проверка работы метода.
 */
public class Factorial {

    /** Возвращает n! для 0 <= n <= 20 (дальше значение не помещается в long). */
    public static long factorial(int n) {
        if (n < 0 || n > 20) {
            throw new IllegalArgumentException("n должно быть в диапазоне от 0 до 20, получено: " + n);
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] tests = {0, 1, 5, 10, 15, 20};
        for (int n : tests) {
            System.out.printf("%2d! = %d%n", n, factorial(n));
        }

        // проверка: n! = n * (n-1)!
        boolean ok = true;
        for (int n = 1; n <= 20; n++) {
            if (factorial(n) != n * factorial(n - 1)) {
                ok = false;
            }
        }
        System.out.println("Проверка n! = n * (n-1)! для n = 1..20: " + (ok ? "пройдена" : "НЕ пройдена"));

        // проверка некорректного аргумента
        try {
            factorial(-3);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
