package part41.library;

/**
 * Читатель библиотеки. Методы takeBook() и returnBook() перегружены.
 */
public class Reader {
    private String fullName;     // в формате "Петров В. В."
    private int ticketNumber;
    private String faculty;
    private String birthDate;
    private String phone;
    private boolean female;      // для согласования глагола: взял / взяла

    public Reader(String fullName, int ticketNumber, String faculty, String birthDate, String phone) {
        this(fullName, ticketNumber, faculty, birthDate, phone, false);
    }

    public Reader(String fullName, int ticketNumber, String faculty, String birthDate, String phone,
                  boolean female) {
        this.female = female;
        this.fullName = fullName;
        this.ticketNumber = ticketNumber;
        this.faculty = faculty;
        this.birthDate = birthDate;
        this.phone = phone;
    }

    public String getFullName() {
        return fullName;
    }

    /** Правильное окончание: 1 книгу, 2 книги, 5 книг. */
    private static String books(int n) {
        int mod100 = n % 100;
        int mod10 = n % 10;
        if (mod100 >= 11 && mod100 <= 14) {
            return n + " книг";
        }
        if (mod10 == 1) {
            return n + " книгу";
        }
        if (mod10 >= 2 && mod10 <= 4) {
            return n + " книги";
        }
        return n + " книг";
    }

    private String took() {
        return female ? "взяла" : "взял";
    }

    private String returned() {
        return female ? "вернула" : "вернул";
    }

    public void takeBook(int count) {
        System.out.println(fullName + " " + took() + " " + books(count));
    }

    public void takeBook(String... titles) {
        System.out.println(fullName + " " + took() + " книги: " + String.join(", ", titles));
    }

    public void takeBook(Book... books) {
        System.out.println(fullName + " " + took() + " книги: " + titlesOf(books));
    }

    public void returnBook(int count) {
        System.out.println(fullName + " " + returned() + " " + books(count));
    }

    public void returnBook(String... titles) {
        System.out.println(fullName + " " + returned() + " книги: " + String.join(", ", titles));
    }

    public void returnBook(Book... books) {
        System.out.println(fullName + " " + returned() + " книги: " + titlesOf(books));
    }

    private static String titlesOf(Book[] books) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < books.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(books[i].getTitle());
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return String.format("%-14s билет №%d, %s, д.р. %s, тел. %s",
                fullName, ticketNumber, faculty, birthDate, phone);
    }
}
