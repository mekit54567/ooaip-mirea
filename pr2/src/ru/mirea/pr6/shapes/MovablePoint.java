package ru.mirea.pr6.shapes;

import ru.mirea.pr6.movable.Movable;

/**
 * Задание 5. Движущаяся точка для фигур из ПР № 5: хранит положение
 * (координаты) и скорость по осям, реализует интерфейс Movable.
 */
public class MovablePoint implements Movable {
    private int x;
    private int y;
    private int xSpeed;
    private int ySpeed;

    public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getXSpeed() {
        return xSpeed;
    }

    public int getYSpeed() {
        return ySpeed;
    }

    // ось Y направлена вверх, как в математике
    @Override
    public void moveUp() {
        y += ySpeed;
    }

    @Override
    public void moveDown() {
        y -= ySpeed;
    }

    @Override
    public void moveLeft() {
        x -= xSpeed;
    }

    @Override
    public void moveRight() {
        x += xSpeed;
    }

    @Override
    public String toString() {
        return "MovablePoint[(" + x + ", " + y + "), speed=(" + xSpeed + ", " + ySpeed + ")]";
    }
}
