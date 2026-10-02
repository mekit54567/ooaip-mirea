package ru.mirea.pr6.movable;

/**
 * Движущаяся окружность: агрегирует одну движущуюся точку - центр.
 */
public class MovableCircle implements Movable {
    private int radius;
    private MovablePoint center;

    public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
        this.center = new MovablePoint(x, y, xSpeed, ySpeed);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public MovablePoint getCenter() {
        return center;
    }

    // окружность двигается вместе со своим центром
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
        return "MovableCircle[center=" + center + ", radius=" + radius + "]";
    }
}
