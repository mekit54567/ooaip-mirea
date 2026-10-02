package part41.transport;

public class TransportDemo {
    public static void main(String[] args) {
        Transport[] fleet = {
                new Car("Lada Vesta"),
                new Plane("Airbus A320"),
                new Train("Сапсан"),
                new Ship("Волго-Дон 5000")
        };

        double distance = 700;   // км
        int passengers = 150;
        double cargo = 12;       // т

        System.out.printf("Перевозка: %.0f км, %d пассажиров, %.1f т груза%n", distance, passengers, cargo);
        for (Transport t : fleet) {
            t.printReport(distance, passengers, cargo);
        }

        System.out.println();
        System.out.println("Только пассажиры (4 человека, 120 км):");
        for (Transport t : fleet) {
            t.printReport(120, 4, 0);
        }
    }
}
