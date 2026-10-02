package part41.person;

public class Person {
    private String fullName;
    private int age;

    public Person() {
        this.fullName = "Без имени";
        this.age = 0;
    }

    public Person(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }

    public void move() {
        System.out.println(fullName + " идет");
    }

    public void talk() {
        System.out.println(fullName + " говорит");
    }

    @Override
    public String toString() {
        return "Person{fullName='" + fullName + "', age=" + age + "}";
    }
}
