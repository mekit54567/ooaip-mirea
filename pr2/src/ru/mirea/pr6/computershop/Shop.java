package ru.mirea.pr6.computershop;

import java.util.ArrayList;
import java.util.List;

/** Интернет-магазин компьютерной техники. */
public class Shop {
    private String name;
    private List<Computer> computers = new ArrayList<>();

    public Shop(String name) {
        this.name = name;
    }

    public void addComputer(Computer c) {
        computers.add(c);
    }

    /** Удаление по номеру в списке (нумерация с 1). */
    public Computer removeComputer(int number) {
        if (number < 1 || number > computers.size()) {
            return null;
        }
        return computers.remove(number - 1);
    }

    /**
     * Поиск подходящих компьютеров.
     * brand == null означает "любая марка".
     */
    public List<Computer> find(Brand brand, int minRamGb, double maxPrice) {
        List<Computer> result = new ArrayList<>();
        for (Computer c : computers) {
            boolean brandOk = brand == null || c.getBrand() == brand;
            if (brandOk && c.getMemory().getSizeGb() >= minRamGb && c.getPrice() <= maxPrice) {
                result.add(c);
            }
        }
        return result;
    }

    public int size() {
        return computers.size();
    }

    public void printAll() {
        System.out.println("Магазин \"" + name + "\", компьютеров: " + computers.size());
        for (int i = 0; i < computers.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + computers.get(i));
        }
    }
}
