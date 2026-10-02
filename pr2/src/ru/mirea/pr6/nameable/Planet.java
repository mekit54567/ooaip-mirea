package ru.mirea.pr6.nameable;

public class Planet implements Nameable {
    private String name;
    private double radiusKm;

    public Planet(String name, double radiusKm) {
        this.name = name;
        this.radiusKm = radiusKm;
    }

    @Override
    public String getName() {
        return "планета " + name;
    }

    public double getRadiusKm() {
        return radiusKm;
    }
}
