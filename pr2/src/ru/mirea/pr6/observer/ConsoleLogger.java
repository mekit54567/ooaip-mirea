package ru.mirea.pr6.observer;

/** Наблюдатель, который пишет все изменения в консоль. */
public class ConsoleLogger implements StringChangeListener {
    @Override
    public void onChange(String operation, String newValue) {
        System.out.println("[Лог] " + operation + " -> \"" + newValue + "\"");
    }
}
