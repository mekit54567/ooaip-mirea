package part41.shapes;

/**
 * Класс-тестер: все объекты хранятся в ссылках родительского типа Shape.
 */
public class ShapeTest {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Shape("white"),
                new Circle(2.5, "red"),
                new Rectangle(3, 5, "green"),
                new Square(4, "blue")
        };

        for (Shape s : shapes) {
            System.out.println(s);
            System.out.println("  тип: " + s.getType()
                    + ", реальный класс: " + s.getClass().getSimpleName());
            System.out.printf("  площадь = %.3f, периметр = %.3f%n", s.getArea(), s.getPerimeter());
        }
    }
}
