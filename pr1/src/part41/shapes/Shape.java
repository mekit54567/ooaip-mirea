package part41.shapes;

/**
 * Простейший (неабстрактный) класс "Фигура" для задания 1 ПР 4.1.
 */
public class Shape {
    protected String color;

    public Shape() {
        this("black");
    }

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public String getType() {
        return "Фигура";
    }

    public double getArea() {
        return 0;
    }

    public double getPerimeter() {
        return 0;
    }

    @Override
    public String toString() {
        return getType() + " (цвет " + color + ")";
    }
}
