package ru.mirea.pr6.priceable;

public class TestPriceable {
    public static void main(String[] args) {
        Priceable[] cart = {
                new Phone("Xiaomi Redmi Note 13", 21990),
                new Ticket("Москва - Санкт-Петербург", 3200, false),
                new Ticket("Москва - Тверь", 900, true),
                new Pizza("Маргарита", 30)
        };
        double total = 0;
        for (Priceable p : cart) {
            System.out.printf("%-35s %10.2f руб.%n", p, p.getPrice());
            total += p.getPrice();
        }
        System.out.printf("%-35s %10.2f руб.%n", "ИТОГО:", total);
    }
}
