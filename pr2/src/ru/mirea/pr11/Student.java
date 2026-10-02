package ru.mirea.pr11;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Задание 3. Студент с датой рождения.
 */
public class Student {
    private static final Locale RU = new Locale("ru", "RU");

    private String surname;
    private String name;
    private String group;
    private Date birthDate;

    public Student(String surname, String name, String group, Date birthDate) {
        this.surname = surname;
        this.name = name;
        this.group = group;
        this.birthDate = birthDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * Дата рождения в одном из стандартных форматов:
     * DateFormat.SHORT, MEDIUM, LONG или FULL.
     */
    public String getBirthDate(int style) {
        return DateFormat.getDateInstance(style, RU).format(birthDate);
    }

    /** Дата рождения по шаблону, например "dd/MM/yyyy". */
    public String getBirthDate(String pattern) {
        return new SimpleDateFormat(pattern, RU).format(birthDate);
    }

    /** Строковое представление с выбранным форматом даты рождения. */
    public String toString(int dateStyle) {
        return "Student{" + surname + " " + name + ", группа " + group
                + ", дата рождения: " + getBirthDate(dateStyle) + "}";
    }

    @Override
    public String toString() {
        return toString(DateFormat.MEDIUM);
    }
}
