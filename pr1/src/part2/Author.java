package part2;

/**
 * Класс Author моделирует автора книги (по UML-диаграмме).
 */
public class Author {
    private String name;
    private String email;
    private char gender; // 'M' - мужчина, 'F' - женщина, 'U' - неизвестно

    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        gender = Character.toUpperCase(gender);
        if (gender != 'M' && gender != 'F' && gender != 'U') {
            throw new IllegalArgumentException(
                    "Недопустимое значение пола '" + gender + "': ожидается 'M', 'F' или 'U'");
        }
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getGender() {
        return gender;
    }

    // сеттеров для name и gender нет - эти атрибуты не изменяются

    /** Обозначение пола в строковом представлении (как в примере задания: m, ms, u). */
    private String genderTitle() {
        switch (gender) {
            case 'M': return "m";
            case 'F': return "ms";
            default:  return "u";
        }
    }

    @Override
    public String toString() {
        return name + " (" + genderTitle() + ") at " + email;
    }
}
