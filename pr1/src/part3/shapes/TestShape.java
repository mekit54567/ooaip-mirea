package part3.shapes;

/**
 * Тестовый класс к заданию 1. Строки исходного листинга, которые не
 * компилируются, закомментированы и заменены рабочими вариантами
 * (с явным приведением типа).
 */
public class TestShape {
    public static void main(String[] args) {
        Shape s1 = new Circle(5.5, "RED", false); // Upcast Circle to Shape
        System.out.println(s1);                   // Circle.toString()
        System.out.println(s1.getArea());         // Circle.getArea()
        System.out.println(s1.getPerimeter());    // Circle.getPerimeter()
        System.out.println(s1.getColor());
        System.out.println(s1.isFilled());
        // System.out.println(s1.getRadius());    // ОШИБКА: в классе Shape нет getRadius()
        System.out.println(((Circle) s1).getRadius());

        Circle c1 = (Circle) s1;                  // Downcast back to Circle
        System.out.println(c1);
        System.out.println(c1.getArea());
        System.out.println(c1.getPerimeter());
        System.out.println(c1.getColor());
        System.out.println(c1.isFilled());
        System.out.println(c1.getRadius());

        // Shape s2 = new Shape();                // ОШИБКА: Shape - абстрактный класс

        Shape s3 = new Rectangle(1.0, 2.0, "RED", false); // Upcast
        System.out.println(s3);
        System.out.println(s3.getArea());
        System.out.println(s3.getPerimeter());
        System.out.println(s3.getColor());
        // System.out.println(s3.getLength());    // ОШИБКА: в классе Shape нет getLength()
        System.out.println(((Rectangle) s3).getLength());

        Rectangle r1 = (Rectangle) s3;            // downcast
        System.out.println(r1);
        System.out.println(r1.getArea());
        System.out.println(r1.getColor());
        System.out.println(r1.getLength());

        Shape s4 = new Square(6.6);               // Upcast
        System.out.println(s4);
        System.out.println(s4.getArea());
        System.out.println(s4.getColor());
        // System.out.println(s4.getSide());      // ОШИБКА: в классе Shape нет getSide()
        System.out.println(((Square) s4).getSide());

        // Take note that we downcast Shape s4 to Rectangle,
        // which is a superclass of Square, instead of Square
        Rectangle r2 = (Rectangle) s4;
        System.out.println(r2);
        System.out.println(r2.getArea());
        System.out.println(r2.getColor());
        // System.out.println(r2.getSide());      // ОШИБКА: в классе Rectangle нет getSide()
        System.out.println(((Square) r2).getSide());
        System.out.println(r2.getLength());

        // Downcast Rectangle r2 to Square
        Square sq1 = (Square) r2;
        System.out.println(sq1);
        System.out.println(sq1.getArea());
        System.out.println(sq1.getColor());
        System.out.println(sq1.getSide());
        System.out.println(sq1.getLength());

        // Демонстрация полиморфизма: один и тот же вызов для разных объектов
        System.out.println("--- Полиморфизм: массив Shape[] ---");
        Shape[] shapes = {s1, s3, s4, new Circle(), new Rectangle(3, 4)};
        for (Shape s : shapes) {
            System.out.printf("%-10s площадь = %8.3f, периметр = %7.3f%n",
                    s.getClass().getSimpleName(), s.getArea(), s.getPerimeter());
        }

        // Недопустимое нисходящее преобразование: ошибка во время выполнения
        try {
            Circle wrong = (Circle) s3;
            System.out.println(wrong);
        } catch (ClassCastException e) {
            System.out.println("ClassCastException: " + e.getMessage());
        }
    }
}
