package ru.mirea.pr6.temperature;

/** Задание 11. Перевод температуры из градусов Цельсия в другую шкалу. */
public interface Convertable {
    double convert(double celsius);

    String getScaleName();
}
