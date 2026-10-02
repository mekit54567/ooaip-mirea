package part41.shapes;

public class Square extends Rectangle {

    public Square(double side, String color) {
        super(side, side, color);
    }

    @Override
    public String getType() {
        return "Квадрат";
    }

    // площадь и периметр квадрата - частный случай прямоугольника,
    // но переопределяем по заданию через сторону
    @Override
    public double getArea() {
        return width * width;
    }

    @Override
    public double getPerimeter() {
        return 4 * width;
    }

    @Override
    public String toString() {
        return getType() + " (цвет " + color + "), сторона " + width;
    }
}
