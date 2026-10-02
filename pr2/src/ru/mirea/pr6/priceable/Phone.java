package ru.mirea.pr6.priceable;

public class Phone implements Priceable {
    private String model;
    private double price;

    public Phone(String model, double price) {
        this.model = model;
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Телефон " + model;
    }
}
