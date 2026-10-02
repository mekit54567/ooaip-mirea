package ru.mirea.pr6.computershop;

/** Оперативная память. */
public class Memory {
    private int sizeGb;
    private String type;

    public Memory(int sizeGb, String type) {
        this.sizeGb = sizeGb;
        this.type = type;
    }

    public int getSizeGb() {
        return sizeGb;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return sizeGb + " ГБ " + type;
    }
}
