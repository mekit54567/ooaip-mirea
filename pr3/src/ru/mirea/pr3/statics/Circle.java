package ru.mirea.pr3.statics;

/** Класс Circle со статической переменной - счетчиком созданных объектов */
public class Circle {
    /** Радиус круга (переменная экземпляра) */
    double radius;

    /** Количество созданных объектов (переменная класса) */
    static int numberOfObjects = 0;

    /** Создает круг с радиусом, равным 1 */
    public Circle() {
        radius = 1.0;
        numberOfObjects++;
    }

    /** Создает круг с указанным радиусом */
    public Circle(double newRadius) {
        radius = newRadius;
        numberOfObjects++;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    /** Возвращает количество созданных объектов */
    public static int getNumberOfObjects() {
        return numberOfObjects;
    }

    /** Возвращает площадь круга */
    public double getArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public String toString() {
        return String.format("Circle[r=%.2f, S=%.2f]", radius, getArea());
    }
}
