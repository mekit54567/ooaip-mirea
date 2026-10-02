package ru.mirea.pr6.nameable;

public class TestNameable {
    public static void main(String[] args) {
        Nameable[] things = {
                new Planet("Земля", 6371),
                new Planet("Марс", 3389.5),
                new Car("Lada", "Vesta"),
                new Animal("кот", "Барсик"),
                new Animal("собака", "Шарик")
        };
        for (Nameable n : things) {
            System.out.println(n.getClass().getSimpleName() + " -> " + n.getName());
        }
    }
}
