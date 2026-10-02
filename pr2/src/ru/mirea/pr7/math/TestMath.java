package ru.mirea.pr7.math;

public class TestMath {
    public static void main(String[] args) {
        MathCalculable mc = new MathFunc();   // правильно
        // MathCalculable mc2 = new MathCalculable(); // ошибка компиляции
        System.out.println("PI из интерфейса = " + MathCalculable.PI);
        System.out.println("2^10 = " + mc.pow(2, 10));
        System.out.println("1.5^3 = " + mc.pow(1.5, 3));
        System.out.println("2^-2 = " + mc.pow(2, -2));
        System.out.println("|3 + 4i| = " + mc.complexAbs(3, 4));
        System.out.println("|1 - 1i| = " + mc.complexAbs(1, -1));

        MathFunc mf = (MathFunc) mc;
        System.out.printf("Длина окружности радиуса 5 = %.4f%n", mf.circleLength(5));
        System.out.printf("Площадь круга радиуса 5 = %.4f%n", mf.circleArea(5));
    }
}
