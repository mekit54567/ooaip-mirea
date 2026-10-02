package ru.mirea.pr4.recursion;

/** Задание 16. Количество элементов, равных максимуму. */
public class Task16 {

    /** Результат функции: максимум и количество элементов, равных ему (аналог кортежа). */
    static final class MaxCount {
        final int max;
        final int count;

        MaxCount(int max, int count) {
            this.max = max;
            this.count = count;
        }
    }

    // функция без параметров возвращает пару (максимум, количество)
    // для оставшейся части последовательности
    static MaxCount maxAndCount() {
        int x = readInt();
        if (x == 0) {
            return new MaxCount(0, 0);
        }
        MaxCount rest = maxAndCount();
        if (x > rest.max) {
            return new MaxCount(x, 1);
        }
        if (x == rest.max) {
            return new MaxCount(x, rest.count + 1);
        }
        return rest;
    }

    // Считывание очередного натурального числа с клавиатуры (одно число в строке).
    // Байты читаются прямо из System.in, поэтому не нужны ни Scanner в поле класса
    // (глобальная переменная), ни параметр у рекурсивной функции. Вспомогательные
    // функции тоже рекурсивные, без циклов. При конце ввода возвращается 0.
    static int readInt() {
        int c = skipToDigit();
        return c == -1 ? 0 : readDigits(c - '0');
    }

    // пропускает пробелы и переводы строк, возвращает первую цифру (или -1)
    static int skipToDigit() {
        int c = readChar();
        if (c == -1 || (c >= '0' && c <= '9')) {
            return c;
        }
        return skipToDigit();
    }

    // дописывает к уже прочитанной части числа следующие цифры
    static int readDigits(int acc) {
        int c = readChar();
        if (c < '0' || c > '9') {
            return acc;
        }
        return readDigits(acc * 10 + (c - '0'));
    }

    static int readChar() {
        try {
            return System.in.read();
        } catch (java.io.IOException e) {
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(maxAndCount().count);
    }
}
