package ru.mirea.pr7.printable;

public class Book implements Printable {
    private String name;
    private String author;
    private int year;

    public Book(String name, String author, int year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    @Override
    public void print() {
        System.out.printf("Книга '%s' (автор %s) была издана в %d году%n", name, author, year);
    }

    /** Задание 8. Вывод названий только книг. */
    public static void printBooks(Printable[] printable) {
        for (Printable p : printable) {
            if (p instanceof Book) {
                System.out.println("  " + ((Book) p).getName());
            }
        }
    }
}
