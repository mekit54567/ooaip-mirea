package ru.mirea.pr7.printable;

public class TestPrintable {
    public static void main(String[] args) {
        Printable printable = createPrintable("Компьютерра", false);
        printable.print();
        read(new Book("Отцы и дети", "И. Тургенев", 1862));
        read(new Magazine("Хакер"));

        Printable[] library = {
                new Book("Война и мир", "Л. Н. Толстой", 1869),
                new Magazine("Хакер"),
                new Book("Мастер и Маргарита", "М. А. Булгаков", 1967),
                new Magazine("Наука и жизнь"),
                createPrintable("Мертвые души", true),
                new Magazine("Вокруг света")
        };
        System.out.println();
        System.out.println("Все издания:");
        for (Printable p : library) {
            p.print();
        }
        System.out.println();
        System.out.println("Только журналы (Magazine.printMagazines):");
        Magazine.printMagazines(library);
        System.out.println("Только книги (Book.printBooks):");
        Book.printBooks(library);
    }

    static void read(Printable p) {
        p.print();
    }

    static Printable createPrintable(String name, boolean option) {
        if (option) {
            return new Book(name, "неизвестен", 2015);
        } else {
            return new Magazine(name);
        }
    }
}
