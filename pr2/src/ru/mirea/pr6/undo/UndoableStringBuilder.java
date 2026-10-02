package ru.mirea.pr6.undo;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Задание 12. Обертка над StringBuilder с поддержкой undo().
 * StringBuilder объявлен final, поэтому используется делегирование:
 * каждый изменяющий метод выполняет действие над внутренним sb и
 * кладет в стек команду, которая умеет это действие отменить.
 * Неизменяющие методы просто передаются внутреннему StringBuilder.
 */
public class UndoableStringBuilder implements CharSequence {
    private final StringBuilder sb;
    private final Deque<Command> history = new ArrayDeque<>();

    public UndoableStringBuilder() {
        sb = new StringBuilder();
    }

    public UndoableStringBuilder(int capacity) {
        sb = new StringBuilder(capacity);
    }

    public UndoableStringBuilder(String s) {
        sb = new StringBuilder(s);
    }

    public UndoableStringBuilder(CharSequence cs) {
        sb = new StringBuilder(cs);
    }

    // ---------------------------------------------------------- append
    // все варианты append сводятся к добавлению строкового представления
    public UndoableStringBuilder append(String s) {
        int oldLength = sb.length();
        sb.append(s);                       // null добавляется как "null", как в StringBuilder
        history.push(() -> sb.setLength(oldLength));
        return this;
    }

    public UndoableStringBuilder append(Object obj) {
        return append(String.valueOf(obj));
    }

    public UndoableStringBuilder append(StringBuffer s) {
        return append(String.valueOf(s));
    }

    public UndoableStringBuilder append(CharSequence s) {
        return append(String.valueOf(s));
    }

    public UndoableStringBuilder append(CharSequence s, int start, int end) {
        return append((s == null ? "null" : s.toString()).substring(start, end));
    }

    public UndoableStringBuilder append(char[] str) {
        return append(String.valueOf(str));
    }

    public UndoableStringBuilder append(char[] str, int offset, int len) {
        return append(String.valueOf(str, offset, len));
    }

    public UndoableStringBuilder append(boolean b) {
        return append(String.valueOf(b));
    }

    public UndoableStringBuilder append(char c) {
        return append(String.valueOf(c));
    }

    public UndoableStringBuilder append(int i) {
        return append(String.valueOf(i));
    }

    public UndoableStringBuilder append(long l) {
        return append(String.valueOf(l));
    }

    public UndoableStringBuilder append(float f) {
        return append(String.valueOf(f));
    }

    public UndoableStringBuilder append(double d) {
        return append(String.valueOf(d));
    }

    public UndoableStringBuilder appendCodePoint(int codePoint) {
        return append(new String(Character.toChars(codePoint)));
    }

    // ---------------------------------------------------------- insert
    public UndoableStringBuilder insert(int offset, String s) {
        String str = String.valueOf(s);     // null вставляется как "null", как в StringBuilder
        sb.insert(offset, str);
        history.push(() -> sb.delete(offset, offset + str.length()));
        return this;
    }

    public UndoableStringBuilder insert(int offset, Object obj) {
        return insert(offset, String.valueOf(obj));
    }

    public UndoableStringBuilder insert(int offset, CharSequence s) {
        return insert(offset, String.valueOf(s));
    }

    public UndoableStringBuilder insert(int dstOffset, CharSequence s, int start, int end) {
        return insert(dstOffset, (s == null ? "null" : s.toString()).substring(start, end));
    }

    public UndoableStringBuilder insert(int offset, char[] str) {
        return insert(offset, String.valueOf(str));
    }

    public UndoableStringBuilder insert(int index, char[] str, int offset, int len) {
        return insert(index, String.valueOf(str, offset, len));
    }

    public UndoableStringBuilder insert(int offset, boolean b) {
        return insert(offset, String.valueOf(b));
    }

    public UndoableStringBuilder insert(int offset, char c) {
        return insert(offset, String.valueOf(c));
    }

    public UndoableStringBuilder insert(int offset, int i) {
        return insert(offset, String.valueOf(i));
    }

    public UndoableStringBuilder insert(int offset, long l) {
        return insert(offset, String.valueOf(l));
    }

    public UndoableStringBuilder insert(int offset, float f) {
        return insert(offset, String.valueOf(f));
    }

    public UndoableStringBuilder insert(int offset, double d) {
        return insert(offset, String.valueOf(d));
    }

    // ---------------------------------------------------------- другие изменения
    public UndoableStringBuilder delete(int start, int end) {
        String removed = sb.substring(start, Math.min(end, sb.length()));
        sb.delete(start, end);
        history.push(() -> sb.insert(start, removed));
        return this;
    }

    public UndoableStringBuilder deleteCharAt(int index) {
        char removed = sb.charAt(index);
        sb.deleteCharAt(index);
        history.push(() -> sb.insert(index, removed));
        return this;
    }

    public UndoableStringBuilder replace(int start, int end, String s) {
        String removed = sb.substring(start, Math.min(end, sb.length()));
        sb.replace(start, end, s);
        history.push(() -> sb.replace(start, start + s.length(), removed));
        return this;
    }

    public UndoableStringBuilder reverse() {
        String old = sb.toString();         // reverse() особо обрабатывает суррогатные пары
        sb.reverse();
        history.push(() -> restore(old));
        return this;
    }

    public void setCharAt(int index, char c) {
        char old = sb.charAt(index);
        sb.setCharAt(index, c);
        history.push(() -> sb.setCharAt(index, old));
    }

    public void setLength(int newLength) {
        String old = sb.toString();
        sb.setLength(newLength);
        history.push(() -> restore(old));
    }

    private void restore(String value) {
        sb.setLength(0);
        sb.append(value);
    }

    /** Отмена последней операции. Возвращает false, если отменять нечего. */
    public boolean undo() {
        if (history.isEmpty()) {
            return false;
        }
        history.pop().undo();
        return true;
    }

    // ---------------------------------------------------------- методы, не меняющие строку
    @Override
    public int length() {
        return sb.length();
    }

    @Override
    public char charAt(int index) {
        return sb.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return sb.subSequence(start, end);
    }

    public int capacity() {
        return sb.capacity();
    }

    public void ensureCapacity(int minimumCapacity) {
        sb.ensureCapacity(minimumCapacity);
    }

    public void trimToSize() {
        sb.trimToSize();
    }

    public int codePointAt(int index) {
        return sb.codePointAt(index);
    }

    public void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) {
        sb.getChars(srcBegin, srcEnd, dst, dstBegin);
    }

    public String substring(int start) {
        return sb.substring(start);
    }

    public String substring(int start, int end) {
        return sb.substring(start, end);
    }

    public int indexOf(String s) {
        return sb.indexOf(s);
    }

    public int indexOf(String s, int fromIndex) {
        return sb.indexOf(s, fromIndex);
    }

    public int lastIndexOf(String s) {
        return sb.lastIndexOf(s);
    }

    public int lastIndexOf(String s, int fromIndex) {
        return sb.lastIndexOf(s, fromIndex);
    }

    @Override
    public String toString() {
        return sb.toString();
    }
}
