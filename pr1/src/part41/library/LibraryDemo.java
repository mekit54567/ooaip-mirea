package part41.library;

public class LibraryDemo {
    public static void main(String[] args) {
        Reader[] readers = {
                new Reader("Петров В. В.", 1001, "ИКБ", "12.03.2006", "+7-915-000-00-01"),
                new Reader("Иванова А. С.", 1002, "ИИТ", "25.11.2005", "+7-915-000-00-02", true),
                new Reader("Сидоров К. Н.", 1003, "ИКБ", "07.07.2006", "+7-915-000-00-03")
        };

        System.out.println("Читатели библиотеки:");
        for (Reader r : readers) {
            System.out.println("  " + r);
        }
        System.out.println();

        Reader petrov = readers[0];
        petrov.takeBook(3);
        petrov.takeBook("Приключения", "Словарь", "Энциклопедия");
        petrov.takeBook(new Book("Приключения", "Майн Рид"),
                new Book("Словарь", "Ожегов С. И."),
                new Book("Энциклопедия", "коллектив авторов"));
        petrov.returnBook("Приключения", "Словарь", "Энциклопедия");
        petrov.returnBook(3);

        readers[1].takeBook(1);
        readers[1].returnBook(new Book("Мастер и Маргарита", "Булгаков М. А."));
        readers[2].takeBook(5);
    }
}
