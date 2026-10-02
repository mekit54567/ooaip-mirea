package ru.mirea.pr6.printable;

/** Журнал. */
public class Journal implements Printable {
    private String name;
    private int number;

    public Journal(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    @Override
    public void print() {
        System.out.printf("Журнал '%s', выпуск № %d%n", name, number);
    }
}
