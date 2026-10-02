package dop.rectangle;

/**
 * Прямоугольник (по примеру класса Circle).
 */
public class Rectangle {
    /** Ширина и высота, по умолчанию -1 (по условию задания). */
    double width = -1;
    double height = -1;

    /** Безаргументный конструктор - значения по умолчанию. */
    Rectangle() {
    }

    /** Прямоугольник с указанными шириной и высотой. */
    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    /** Возвращает площадь прямоугольника. */
    double getArea() {
        return width * height;
    }

    /** Возвращает периметр прямоугольника. */
    double getPerimeter() {
        return 2 * (width + height);
    }
}
