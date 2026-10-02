package ru.mirea.pr7.printable;

public class Magazine implements Printable {
    private String name;

    public Magazine(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void print() {
        System.out.printf("Журнал '%s'%n", name);
    }

    /** Задание 7. Вывод названий только журналов. */
    public static void printMagazines(Printable[] printable) {
        for (Printable p : printable) {
            if (p instanceof Magazine) {
                System.out.println("  " + ((Magazine) p).getName());
            }
        }
    }
}
