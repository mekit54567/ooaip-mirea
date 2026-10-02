package part4.computer;

public class Memory {
    private int size;         // Гб
    private final String type; // DDR4, DDR5 ...

    public Memory(int size, String type) {
        this.size = size;
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public String getType() {
        return type;
    }

    /** Добавление планки памяти. */
    public void add(int gigabytes) {
        if (gigabytes <= 0) {
            throw new IllegalArgumentException("объем должен быть положительным");
        }
        size += gigabytes;
    }

    @Override
    public String toString() {
        return size + " Гб " + type;
    }
}
