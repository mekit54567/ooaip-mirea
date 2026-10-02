package ru.mirea.pr7.strings;

/** Задание 6. Реализация интерфейса StringProcessable. */
public class ProcessStrings implements StringProcessable {

    @Override
    public int countChars(String s) {
        return s.length();
    }

    @Override
    public int countChar(String s, char c) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String oddPositions(String s) {
        // позиции считаются с 1, поэтому берем индексы 0, 2, 4, ...
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i += 2) {
            result.append(s.charAt(i));
        }
        return result.toString();
    }

    @Override
    public String invert(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }
        return new String(chars);
    }
}
