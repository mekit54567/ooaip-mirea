package ru.mirea.pr6.printable;

/** Задание 9. Массив Printable с книгами и журналами. */
public class TestPrintable {
    public static void main(String[] args) {
        Printable[] items = {
                new Book("Война и мир", "Л. Н. Толстой", 1869),
                new Journal("Хакер", 287),
                new Book("Отцы и дети", "И. С. Тургенев", 1862),
                new Journal("Наука и жизнь", 9),
                new Shop("Читай-город", "г. Москва, пр-т Вернадского, 78")
        };
        for (Printable p : items) {
            p.print();
        }
    }
}
