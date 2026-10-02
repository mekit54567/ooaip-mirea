package ru.mirea.pr6.movable;

/**
 * Движущийся прямоугольник, заданный двумя точками:
 * верхней левой и нижней правой (рис. 6.4).
 */
public class MovableRectangle implements Movable {
    private MovablePoint topLeft;
    private MovablePoint bottomRight;

    public MovableRectangle(int x1, int y1, int x2, int y2, int xSpeed, int ySpeed) {
        this(new MovablePoint(x1, y1, xSpeed, ySpeed), new MovablePoint(x2, y2, xSpeed, ySpeed));
    }

    /**
     * Точки копируются, чтобы прямоугольник не зависел от внешних объектов
     * (их перемещение снаружи или передача одной и той же точки дважды
     * не нарушат фигуру). Проверяется взаимное расположение углов.
     */
    public MovableRectangle(MovablePoint topLeft, MovablePoint bottomRight) {
        if (topLeft.x > bottomRight.x || topLeft.y < bottomRight.y) {
            throw new IllegalArgumentException(
                    "topLeft должна быть левее и выше bottomRight (ось Y направлена вверх)");
        }
        this.topLeft = new MovablePoint(topLeft.x, topLeft.y, topLeft.xSpeed, topLeft.ySpeed);
        this.bottomRight = new MovablePoint(bottomRight.x, bottomRight.y,
                bottomRight.xSpeed, bottomRight.ySpeed);
    }

    /** Проверка, что обе точки движутся с одинаковой скоростью. */
    public boolean hasSameSpeed() {
        return topLeft.xSpeed == bottomRight.xSpeed
                && topLeft.ySpeed == bottomRight.ySpeed;
    }

    public int getWidth() {
        return bottomRight.x - topLeft.x;
    }

    public int getHeight() {
        return topLeft.y - bottomRight.y;
    }

    // если скорости точек разные, прямоугольник "развалится", поэтому не двигаем его
    private boolean canMove() {
        if (!hasSameSpeed()) {
            System.out.println("  Ошибка: у точек прямоугольника разная скорость, движение невозможно");
            return false;
        }
        return true;
    }

    @Override
    public void moveUp() {
        if (canMove()) {
            topLeft.moveUp();
            bottomRight.moveUp();
        }
    }

    @Override
    public void moveDown() {
        if (canMove()) {
            topLeft.moveDown();
            bottomRight.moveDown();
        }
    }

    @Override
    public void moveLeft() {
        if (canMove()) {
            topLeft.moveLeft();
            bottomRight.moveLeft();
        }
    }

    @Override
    public void moveRight() {
        if (canMove()) {
            topLeft.moveRight();
            bottomRight.moveRight();
        }
    }

    @Override
    public String toString() {
        return "MovableRectangle[topLeft=" + topLeft + ", bottomRight=" + bottomRight + "]";
    }
}
