package part4.computer;

/**
 * Задание 4 (ПР4). Компьютер и его составные части.
 */
public class ComputerDemo {
    public static void main(String[] args) {
        Computer[] computers = {
                new Computer(Brand.LENOVO, new Processor("Intel Core i5-12450H", 8, 2.0),
                        new Memory(16, "DDR4"), new Monitor(15.6, 1920, 1080), 64990),
                new Computer(Brand.APPLE, new Processor("Apple M3", 8, 4.05),
                        new Memory(8, "LPDDR5"), new Monitor(13.6, 2560, 1664), 129990),
                new Computer(Brand.ASUS, new Processor("AMD Ryzen 7 7840HS", 8, 3.8),
                        new Memory(32, "DDR5"), new Monitor(16.0, 2560, 1600), 109990)
        };

        for (Computer c : computers) {
            System.out.println(c);
        }

        System.out.println();
        Computer pc = computers[0];
        pc.turnOn();
        pc.turnOn();
        pc.upgradeMemory(16);
        pc.turnOff();
        System.out.println(pc);

        System.out.println();
        System.out.println("Доступные марки:");
        for (Brand b : Brand.values()) {
            System.out.println("  " + b.ordinal() + ": " + b.name() + " (" + b.getCountry() + ")");
        }
    }
}
