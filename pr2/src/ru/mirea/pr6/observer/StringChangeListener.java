package ru.mirea.pr6.observer;

/** Подписчик (наблюдатель) на изменения строки. */
public interface StringChangeListener {
    void onChange(String operation, String newValue);
}
