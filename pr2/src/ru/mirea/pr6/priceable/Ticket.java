package ru.mirea.pr6.priceable;

/** Билет: цена зависит от базовой стоимости и наличия льготы. */
public class Ticket implements Priceable {
    private String route;
    private double basePrice;
    private boolean student;

    public Ticket(String route, double basePrice, boolean student) {
        this.route = route;
        this.basePrice = basePrice;
        this.student = student;
    }

    @Override
    public double getPrice() {
        return student ? basePrice * 0.5 : basePrice;
    }

    @Override
    public String toString() {
        return "Билет " + route + (student ? " (студ.)" : "");
    }
}
