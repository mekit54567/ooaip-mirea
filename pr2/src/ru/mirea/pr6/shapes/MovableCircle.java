package ru.mirea.pr6.shapes;

import ru.mirea.pr6.movable.Movable;

/**
 * Задание 5. Движущаяся окружность на основе класса Circle из ПР № 5:
 * площадь и периметр наследуются от Circle (и Shape), а движение
 * реализовано через интерфейс Movable - все перемещения делегируются центру.
 */
public class MovableCircle extends Circle implements Movable {
    private final MovablePoint center;

    public MovableCircle(int x, int y, int xSpeed, int ySpeed, double radius, String color) {
        super(radius, color, true);
        this.center = new MovablePoint(x, y, xSpeed, ySpeed);
    }

    public MovablePoint getCenter() {
        return center;
    }

    @Override
    public void moveUp() {
        center.moveUp();
    }

    @Override
    public void moveDown() {
        center.moveDown();
    }

    @Override
    public void moveLeft() {
        center.moveLeft();
    }

    @Override
    public void moveRight() {
        center.moveRight();
    }

    @Override
    public String toString() {
        return "MovableCircle[center=(" + center.getX() + ", " + center.getY()
                + "), radius=" + radius + ", color=" + color + "]";
    }
}
