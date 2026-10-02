package ru.mirea.pr7.math;

/** Задание 4. Математические функции. */
public interface MathCalculable {
    // поле интерфейса неявно public static final
    double PI = 3.141592653589793;

    /** Возведение в целую степень. */
    double pow(double base, int exponent);

    /** Модуль комплексного числа re + im*i. */
    double complexAbs(double re, double im);
}
