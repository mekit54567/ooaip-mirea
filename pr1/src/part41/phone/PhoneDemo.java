package part41.phone;

public class PhoneDemo {
    public static void main(String[] args) {
        Phone p1 = new Phone("+7-915-111-22-33", "iPhone 15", 171);
        Phone p2 = new Phone("+7-926-444-55-66", "Xiaomi 14");
        Phone p3 = new Phone();

        Phone[] phones = {p1, p2, p3};
        for (Phone p : phones) {
            System.out.println(p);
        }
        System.out.println();

        for (Phone p : phones) {
            System.out.println("Номер: " + p.getNumber());
            p.receiveCall("Иван");
        }
        System.out.println();

        p1.receiveCall("Мария", "+7-903-777-88-99");
        p2.sendMessage("+7-915-111-22-33", "+7-999-000-11-22", "+7-985-123-45-67");
    }
}
