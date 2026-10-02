package ru.mirea.pr7.strings;

/** Задание 5. Интерфейс для работы со строками. */
public interface StringProcessable {
    /** а) количество символов в строке. */
    int countChars(String s);

    /** а) сколько раз символ c встречается в строке. */
    int countChar(String s, char c);

    /** б) строка из символов, стоящих на нечетных позициях 1, 3, 5, ... */
    String oddPositions(String s);

    /** в) инвертирование (переворот) строки. */
    String invert(String s);
}
