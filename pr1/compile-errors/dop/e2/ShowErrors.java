public class ShowErrors {
    public void method1() {
        Circle c;
        System.out.println("What is radius " + c.getRadius());
        c = new Circle();
    }
}

class Circle {
    double radius = 1;

    double getRadius() {
        return radius;
    }
}
