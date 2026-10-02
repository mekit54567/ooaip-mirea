package part41.phone;

public class Phone {
    private String number;
    private String model;
    private double weight; // граммы

    public Phone() {
        this("неизвестен", "неизвестна");
    }

    public Phone(String number, String model) {
        this.number = number;
        this.model = model;
    }

    public Phone(String number, String model, double weight) {
        this(number, model); // вызов конструктора с двумя параметрами
        this.weight = weight;
    }

    public String getNumber() {
        return number;
    }

    public String getModel() {
        return model;
    }

    public double getWeight() {
        return weight;
    }

    public void receiveCall(String name) {
        System.out.println("Звонит " + name);
    }

    // перегруженный метод
    public void receiveCall(String name, String callerNumber) {
        System.out.println("Звонит " + name + " (" + callerNumber + ") на номер " + number);
    }

    /** Метод с переменным числом аргументов. */
    public void sendMessage(String... numbers) {
        System.out.println("Сообщение с " + number + " отправлено на номера:");
        for (String n : numbers) {
            System.out.println("  " + n);
        }
    }

    @Override
    public String toString() {
        return "Phone{number='" + number + "', model='" + model + "', weight=" + weight + "}";
    }
}
