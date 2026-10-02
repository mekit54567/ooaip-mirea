package ru.mirea.pr6.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Задание 13. StringBuilder, оповещающий подписчиков о каждом изменении
 * (шаблон "Наблюдатель"). Все операции делегируются стандартному StringBuilder:
 * изменяющие методы после выполнения вызывают notifyListeners(),
 * неизменяющие просто передаются внутреннему объекту.
 */
public class ObservableStringBuilder implements CharSequence {
    private final StringBuilder sb;
    private final List<StringChangeListener> listeners = new ArrayList<>();

    public ObservableStringBuilder() {
        sb = new StringBuilder();
    }

    public ObservableStringBuilder(String s) {
        sb = new StringBuilder(s);
    }

    public void subscribe(StringChangeListener listener) {
        listeners.add(listener);
    }

    public void unsubscribe(StringChangeListener listener) {
        listeners.remove(listener);
    }

    private void notifyListeners(String operation) {
        String value = sb.toString();
        // копия списка: подписчик может отписаться прямо во время оповещения
        for (StringChangeListener l : new ArrayList<>(listeners)) {
            l.onChange(operation, value);
        }
    }

    // ---------------------------------------------------------- append
    public ObservableStringBuilder append(String s) {
        sb.append(s);
        notifyListeners("append(\"" + s + "\")");
        return this;
    }

    public ObservableStringBuilder append(Object obj) {
        return append(String.valueOf(obj));
    }

    public ObservableStringBuilder append(CharSequence s) {
        return append(String.valueOf(s));
    }

    public ObservableStringBuilder append(char[] str) {
        return append(String.valueOf(str));
    }

    public ObservableStringBuilder append(boolean b) {
        return append(String.valueOf(b));
    }

    public ObservableStringBuilder append(char c) {
        return append(String.valueOf(c));
    }

    public ObservableStringBuilder append(int i) {
        return append(String.valueOf(i));
    }

    public ObservableStringBuilder append(long l) {
        return append(String.valueOf(l));
    }

    public ObservableStringBuilder append(float f) {
        return append(String.valueOf(f));
    }

    public ObservableStringBuilder append(double d) {
        return append(String.valueOf(d));
    }

    // ---------------------------------------------------------- insert
    public ObservableStringBuilder insert(int offset, String s) {
        sb.insert(offset, s);
        notifyListeners("insert(" + offset + ", \"" + s + "\")");
        return this;
    }

    public ObservableStringBuilder insert(int offset, Object obj) {
        return insert(offset, String.valueOf(obj));
    }

    public ObservableStringBuilder insert(int offset, CharSequence s) {
        return insert(offset, String.valueOf(s));
    }

    public ObservableStringBuilder insert(int offset, char[] str) {
        return insert(offset, String.valueOf(str));
    }

    public ObservableStringBuilder insert(int offset, boolean b) {
        return insert(offset, String.valueOf(b));
    }

    public ObservableStringBuilder insert(int offset, char c) {
        return insert(offset, String.valueOf(c));
    }

    public ObservableStringBuilder insert(int offset, int i) {
        return insert(offset, String.valueOf(i));
    }

    public ObservableStringBuilder insert(int offset, long l) {
        return insert(offset, String.valueOf(l));
    }

    public ObservableStringBuilder insert(int offset, float f) {
        return insert(offset, String.valueOf(f));
    }

    public ObservableStringBuilder insert(int offset, double d) {
        return insert(offset, String.valueOf(d));
    }

    // ---------------------------------------------------------- другие изменения
    public ObservableStringBuilder delete(int start, int end) {
        sb.delete(start, end);
        notifyListeners("delete(" + start + ", " + end + ")");
        return this;
    }

    public ObservableStringBuilder deleteCharAt(int index) {
        sb.deleteCharAt(index);
        notifyListeners("deleteCharAt(" + index + ")");
        return this;
    }

    public ObservableStringBuilder replace(int start, int end, String s) {
        sb.replace(start, end, s);
        notifyListeners("replace(" + start + ", " + end + ", \"" + s + "\")");
        return this;
    }

    public ObservableStringBuilder reverse() {
        sb.reverse();
        notifyListeners("reverse()");
        return this;
    }

    public void setCharAt(int index, char c) {
        sb.setCharAt(index, c);
        notifyListeners("setCharAt(" + index + ", '" + c + "')");
    }

    public void setLength(int newLength) {
        sb.setLength(newLength);
        notifyListeners("setLength(" + newLength + ")");
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

    public String substring(int start) {
        return sb.substring(start);
    }

    public String substring(int start, int end) {
        return sb.substring(start, end);
    }

    public int indexOf(String s) {
        return sb.indexOf(s);
    }

    public int lastIndexOf(String s) {
        return sb.lastIndexOf(s);
    }

    @Override
    public String toString() {
        return sb.toString();
    }
}
