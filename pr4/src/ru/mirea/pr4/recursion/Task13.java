package ru.mirea.pr4.recursion;

/** Задание 13. Вывести члены последовательности с нечётными номерами. */
public class Task13 {

    static void printOddPositions() {
        int x = readInt();           // элемент с нечётным номером
        if (x == 0) {
            return;
        }
        System.out.print(x + " ");
        int y = readInt();           // элемент с чётным номером - пропускаем
        if (y == 0) {
            return;
        }
        printOddPositions();
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
        printOddPositions();
    }
}
