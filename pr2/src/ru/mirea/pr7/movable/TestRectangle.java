package ru.mirea.pr7.movable;

public class TestRectangle {
    public static void main(String[] args) {
        MovableRectangle r1 = new MovableRectangle(1, 5, 6, 1, 2, 1);
        System.out.println(r1);
        System.out.println("SpeedTest() = " + r1.SpeedTest());
        r1.moveRight();
        r1.moveRight();
        r1.moveDown();
        System.out.println("После 2 x moveRight(), moveDown():");
        System.out.println(r1);

        System.out.println();
        MovableRectangle r2 = new MovableRectangle(
                new MovablePoint(0, 3, 1, 1), new MovablePoint(3, 0, 5, 1));
        System.out.println(r2);
        System.out.println("SpeedTest() = " + r2.SpeedTest());
        r2.moveLeft();
        System.out.println("После moveLeft() (не двигается, скорости разные):");
        System.out.println(r2);

        System.out.println();
        // защитное копирование: перемещение исходной точки не меняет прямоугольник
        MovablePoint p = new MovablePoint(0, 2, 1, 1);
        MovableRectangle r3 = new MovableRectangle(p, new MovablePoint(2, 0, 1, 1));
        p.moveRight();
        p.moveRight();
        System.out.println("Исходная точка сдвинута снаружи: " + p);
        System.out.println("Прямоугольник не изменился: " + r3);
        try {
            new MovableRectangle(new MovablePoint(5, 0, 1, 1), new MovablePoint(0, 5, 1, 1));
        } catch (IllegalArgumentException e) {
            System.out.println("Неверные углы: " + e.getMessage());
        }
    }
}
