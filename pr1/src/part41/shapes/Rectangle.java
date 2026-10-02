package part41.shapes;

public class Rectangle extends Shape {
    protected double width;
    protected double length;

    public Rectangle(double width, double length, String color) {
        super(color);
        this.width = width;
        this.length = length;
    }

    @Override
    public String getType() {
        return "Прямоугольник";
    }

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + length);
    }

    @Override
    public String toString() {
        return super.toString() + ", стороны " + width + " x " + length;
    }
}
