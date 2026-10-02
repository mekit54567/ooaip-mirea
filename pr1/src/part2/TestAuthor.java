package part2;

/**
 * Тестовый класс для проверки класса Author.
 */
public class TestAuthor {
    public static void main(String[] args) {
        Author a1 = new Author("Tan Ah Teck", "ahTeck@somewhere.com", 'M');
        Author a2 = new Author("Sue Grant", "suGrant@somewhere.com", 'F');
        Author a3 = new Author("John Doe", "jdoe@nowhere.org", 'U');

        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);

        // попытка создать автора с недопустимым значением пола
        try {
            new Author("Bad Gender", "bad@nowhere.org", 'x');
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("Имя: " + a1.getName());
        System.out.println("Email: " + a1.getEmail());
        System.out.println("Пол: " + a1.getGender());

        a1.setEmail("tan.ahteck@newmail.com");
        System.out.println("После setEmail(): " + a1);
    }
}
