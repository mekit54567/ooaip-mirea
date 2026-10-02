package ru.mirea.pr7.math;

public class MathFunc implements MathCalculable {

    @Override
    public double pow(double base, int exponent) {
        double result = 1;
        for (int i = 0; i < Math.abs(exponent); i++) {
            result *= base;
        }
        return exponent < 0 ? 1 / result : result;
    }

    @Override
    public double complexAbs(double re, double im) {
        return Math.sqrt(re * re + im * im);
    }

    /** Длина окружности, используется константа PI из интерфейса. */
    public double circleLength(double radius) {
        return 2 * PI * radius;
    }

    /** Площадь круга. */
    public double circleArea(double radius) {
        return PI * pow(radius, 2);
    }
}
