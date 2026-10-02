package ru.mirea.pr11;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class StudentTest {
    public static void main(String[] args) {
        Student s = new Student("Петров", "Иван", "УИБО-03-24",
                new GregorianCalendar(2006, Calendar.MARCH, 14).getTime());

        System.out.println("toString():       " + s);
        System.out.println("SHORT:  " + s.toString(DateFormat.SHORT));
        System.out.println("MEDIUM: " + s.toString(DateFormat.MEDIUM));
        System.out.println("LONG:   " + s.toString(DateFormat.LONG));
        System.out.println("FULL:   " + s.toString(DateFormat.FULL));
        System.out.println("Свой шаблон \"yyyy-MM-dd\":     " + s.getBirthDate("yyyy-MM-dd"));
        System.out.println("Свой шаблон \"d MMMM yyyy, EEEE\": " + s.getBirthDate("d MMMM yyyy, EEEE"));
    }
}
