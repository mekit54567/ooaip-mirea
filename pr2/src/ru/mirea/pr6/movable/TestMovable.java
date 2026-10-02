package ru.mirea.pr6.movable;

/**
 * Проверка заданий 1 и 2: MovablePoint, MovableCircle, MovableRectangle.
 */
public class TestMovable {
    public static void main(String[] args) {
        System.out.println("=== Задание 1. MovablePoint и MovableCircle ===");
        Movable point = new MovablePoint(0, 0, 2, 3);
        System.out.println("Начало:        " + point);
        point.moveUp();
        System.out.println("moveUp():      " + point);
        point.moveRight();
        System.out.println("moveRight():   " + point);
        point.moveDown();
        point.moveDown();
        System.out.println("2 x moveDown():" + point);

        Movable circle = new MovableCircle(5, 5, 1, 1, 10);
        System.out.println("Начало:        " + circle);
        circle.moveLeft();
        circle.moveUp();
        System.out.println("moveLeft(), moveUp(): " + circle);

        System.out.println();
        System.out.println("=== Задание 2. MovableRectangle ===");
        MovableRectangle rect = new MovableRectangle(0, 10, 20, 0, 5, 5);
        System.out.println("Начало:      " + rect);
        System.out.println("Одинаковая скорость точек: " + rect.hasSameSpeed());
        System.out.println("Ширина = " + rect.getWidth() + ", высота = " + rect.getHeight());
        rect.moveRight();
        rect.moveUp();
        System.out.println("moveRight(), moveUp(): " + rect);
        System.out.println("Ширина = " + rect.getWidth() + ", высота = " + rect.getHeight());

        MovableRectangle bad = new MovableRectangle(
                new MovablePoint(0, 4, 1, 1), new MovablePoint(4, 0, 2, 1));
        System.out.println("Прямоугольник с разными скоростями: " + bad);
        System.out.println("Одинаковая скорость точек: " + bad.hasSameSpeed());
        bad.moveRight();

        System.out.println();
        System.out.println("Массив Movable (полиморфизм):");
        Movable[] objects = {new MovablePoint(1, 1, 1, 1), new MovableCircle(0, 0, 3, 3, 2), rect};
        for (Movable m : objects) {
            m.moveDown();
            System.out.println("  " + m);
        }
    }
}
