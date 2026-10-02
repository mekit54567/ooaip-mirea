package ru.mirea.pr6.computershop;

/** Компьютер, собранный из процессора, памяти и монитора. */
public class Computer {
    private Brand brand;
    private String model;
    private Processor processor;
    private Memory memory;
    private Monitor monitor;
    private double price;

    public Computer(Brand brand, String model, Processor processor,
                    Memory memory, Monitor monitor, double price) {
        this.brand = brand;
        this.model = model;
        this.processor = processor;
        this.memory = memory;
        this.monitor = monitor;
        this.price = price;
    }

    public Brand getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
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

    @Override
    public String toString() {
        return String.format("%s %s | CPU: %s | RAM: %s | Монитор: %s | %.0f руб.",
                brand.getTitle(), model, processor, memory, monitor, price);
    }
}
