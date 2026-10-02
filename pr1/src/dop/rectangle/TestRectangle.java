package dop.rectangle;

/**
 * Клиент класса Rectangle.
 */
public class TestRectangle {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(4, 40);
        Rectangle r2 = new Rectangle(3.5, 35.9);
        Rectangle r3 = new Rectangle();

        print("Прямоугольник 1", r1);
        print("Прямоугольник 2", r2);
        print("Прямоугольник по умолчанию", r3);
    }

    private static void print(String title, Rectangle r) {
        System.out.println(title + ":");
        if (r.width < 0 || r.height < 0) {
            // -1 - признак "размер не задан": площадь и периметр не имеют смысла
            System.out.println("  ширина   = " + sizeText(r.width));
            System.out.println("  высота   = " + sizeText(r.height));
            System.out.println("  площадь  = не вычисляется (размеры не заданы)");
            System.out.println("  периметр = не вычисляется (размеры не заданы)");
            return;
        }
        System.out.printf("  ширина   = %.2f%n", r.width);
        System.out.printf("  высота   = %.2f%n", r.height);
        System.out.printf("  площадь  = %.2f%n", r.getArea());
        System.out.printf("  периметр = %.2f%n", r.getPerimeter());
    }

    private static String sizeText(double value) {
        return value < 0 ? "не задана (значение по умолчанию " + value + ")" : String.valueOf(value);
    }
}
