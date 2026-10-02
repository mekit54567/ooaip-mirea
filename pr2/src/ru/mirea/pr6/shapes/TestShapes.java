package ru.mirea.pr6.shapes;

import ru.mirea.pr6.movable.Movable;

/**
 * Проверка задания 5: классы MovablePoint и MovableCircle на основе фигур из ПР № 5.
 */
public class TestShapes {
    public static void main(String[] args) {
        MovablePoint point = new MovablePoint(5, 5, 1, 3);
        MovableCircle circle = new MovableCircle(0, 0, 2, 2, 3.0, "blue");
        Rectangle rect = new Rectangle(4.0, 2.5, "green", false); // обычная фигура ПР № 5

        // окружность можно рассматривать как Shape - работает наследование от ПР № 5
        Shape[] shapes = {circle, rect};
        for (Shape s : shapes) {
            System.out.printf("%s%n   площадь = %.2f, периметр = %.2f%n",
                    s, s.getArea(), s.getPerimeter());
        }

        // и точку, и окружность можно рассматривать как Movable
        Movable[] movables = {point, circle};
        System.out.println("После moveRight() и moveUp():");
        for (Movable m : movables) {
            m.moveRight();
            m.moveUp();
            System.out.println("   " + m);
        }
        circle.moveLeft();
        circle.moveDown();
        System.out.println("После moveLeft() и moveDown() окружности: " + circle);
        System.out.println("Центр окружности: " + circle.getCenter());
        System.out.println("circle instanceof Shape   = " + (circle instanceof Shape));
        System.out.println("circle instanceof Movable = " + (circle instanceof Movable));
        System.out.println("rect instanceof Movable   = " + (rect instanceof Movable));
    }
}
