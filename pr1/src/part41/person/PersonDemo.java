package part41.person;

public class PersonDemo {
    public static void main(String[] args) {
        Person first = new Person();
        Person second = new Person("Петров Василий Викторович", 19);

        System.out.println(first);
        first.move();
        first.talk();

        System.out.println(second);
        second.move();
        second.talk();
    }
}
