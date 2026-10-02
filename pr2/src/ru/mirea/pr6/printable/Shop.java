package ru.mirea.pr6.printable;

/** Задание 8. Магазин, который тоже можно "напечатать". */
public class Shop implements Printable {
    private String name;
    private String address;

    public Shop(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public void print() {
        System.out.printf("Магазин '%s', адрес: %s%n", name, address);
    }
}
