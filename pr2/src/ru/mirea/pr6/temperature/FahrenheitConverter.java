package ru.mirea.pr6.temperature;

public class FahrenheitConverter implements Convertable {
    @Override
    public double convert(double celsius) {
        return celsius * 9 / 5 + 32;
    }

    @Override
    public String getScaleName() {
        return "°F";
    }
}
