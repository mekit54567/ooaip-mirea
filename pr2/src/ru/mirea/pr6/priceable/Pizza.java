package ru.mirea.pr6.priceable;

/** Пицца: цена считается по диаметру. */
public class Pizza implements Priceable {
    private String name;
    private int diameterCm;

    public Pizza(String name, int diameterCm) {
        this.name = name;
        this.diameterCm = diameterCm;
    }

    @Override
    public double getPrice() {
        return 300 + diameterCm * 20;
    }

    @Override
    public String toString() {
        return "Пицца " + name + ", " + diameterCm + " см";
    }
}
