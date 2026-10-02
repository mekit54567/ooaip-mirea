package ru.mirea.pr4.recursion;

/** Задание 12. Вывести нечётные числа последовательности, завершающейся нулём. */
public class Task12 {

    // без параметров, без глобальных переменных, сразу выводит результат
    static void printOdd() {
        int x = readInt();
        if (x == 0) {
            return;
        }
        if (x % 2 != 0) {
            System.out.print(x + " ");
        }
        printOdd();
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
        printOdd();
    }
}
