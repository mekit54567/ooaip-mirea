package part4.computer;

/**
 * Компьютер, состоящий из процессора, памяти и монитора (композиция).
 */
public class Computer {
    private final Brand brand;
    private final Processor processor;
    private final Memory memory;
    private final Monitor monitor;
    private double price;
    private boolean turnedOn;

    public Computer(Brand brand, Processor processor, Memory memory, Monitor monitor, double price) {
        this.brand = brand;
        this.processor = processor;
        this.memory = memory;
        this.monitor = monitor;
        this.price = price;
    }

    public Brand getBrand() {
        return brand;
    }

    public Processor getProcessor() {
        return processor;
    }

    public Memory getMemory() {
        return memory;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public double getPrice() {
        return price;
    }

    public boolean isTurnedOn() {
        return turnedOn;
    }

    public void turnOn() {
        if (turnedOn) {
            System.out.println(brand + ": компьютер уже включен");
        } else {
            turnedOn = true;
            System.out.println(brand + ": компьютер включен");
        }
    }

    public void turnOff() {
        if (!turnedOn) {
            System.out.println(brand + ": компьютер уже выключен");
        } else {
            turnedOn = false;
            System.out.println(brand + ": компьютер выключен");
        }
    }

    /** Апгрейд памяти: увеличивает объем и стоимость (условно 300 руб. за 1 Гб). */
    public void upgradeMemory(int gigabytes) {
        memory.add(gigabytes);
        price += gigabytes * 300;
        System.out.println(brand + ": память увеличена до " + memory);
    }

    @Override
    public String toString() {
        return String.format("Компьютер %s (%s)%n  процессор: %s%n  память:    %s%n  монитор:   %s%n  цена:      %.2f руб.",
                brand, brand.getCountry(), processor, memory, monitor, price);
    }
}
