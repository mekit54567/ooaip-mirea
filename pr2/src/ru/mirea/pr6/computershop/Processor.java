package ru.mirea.pr6.computershop;

public class Processor {
    private String model;
    private int cores;
    private double frequencyGhz;

    public Processor(String model, int cores, double frequencyGhz) {
        this.model = model;
        this.cores = cores;
        this.frequencyGhz = frequencyGhz;
    }

    public String getModel() {
        return model;
    }

    public int getCores() {
        return cores;
    }

    public double getFrequencyGhz() {
        return frequencyGhz;
    }

    @Override
    public String toString() {
        return model + " (" + cores + " ядер, " + frequencyGhz + " ГГц)";
    }
}
