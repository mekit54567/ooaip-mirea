package ru.mirea.pr7.movable;

/**
 * Движущийся прямоугольник: две движущиеся точки topLeft и bottomRight.
 */
public class MovableRectangle implements Movable {
    private MovablePoint topLeft;
    private MovablePoint bottomRight;

    public MovableRectangle(int x1, int y1, int x2, int y2, int xSpeed, int ySpeed) {
        this(new MovablePoint(x1, y1, xSpeed, ySpeed), new MovablePoint(x2, y2, xSpeed, ySpeed));
    }

    /**
     * Точки копируются (защитное копирование), поэтому внешние изменения
     * переданных объектов не влияют на прямоугольник. Проверяется, что
     * topLeft лежит левее и выше bottomRight (ось Y направлена вверх).
     */
    public MovableRectangle(MovablePoint topLeft, MovablePoint bottomRight) {
        if (topLeft.getX() > bottomRight.getX() || topLeft.getY() < bottomRight.getY()) {
            throw new IllegalArgumentException("topLeft должна быть левее и выше bottomRight");
        }
        this.topLeft = new MovablePoint(topLeft.getX(), topLeft.getY(),
                topLeft.getXSpeed(), topLeft.getYSpeed());
        this.bottomRight = new MovablePoint(bottomRight.getX(), bottomRight.getY(),
                bottomRight.getXSpeed(), bottomRight.getYSpeed());
    }

    /**
     * Логический метод: true, если у обеих точек одинаковая скорость.
     * Имя SpeedTest() задано в условии задания (поэтому начинается с прописной буквы).
     */
    public boolean SpeedTest() {
        return topLeft.getXSpeed() == bottomRight.getXSpeed()
                && topLeft.getYSpeed() == bottomRight.getYSpeed();
    }

    @Override
    public void moveUp() {
        if (SpeedTest()) {
            topLeft.moveUp();
            bottomRight.moveUp();
        }
    }

    @Override
    public void moveDown() {
        if (SpeedTest()) {
            topLeft.moveDown();
            bottomRight.moveDown();
        }
    }

    @Override
    public void moveLeft() {
        if (SpeedTest()) {
            topLeft.moveLeft();
            bottomRight.moveLeft();
        }
    }

    @Override
    public void moveRight() {
        if (SpeedTest()) {
            topLeft.moveRight();
            bottomRight.moveRight();
        }
    }

    @Override
    public String toString() {
        return "Прямоугольник: topLeft " + topLeft + ", bottomRight " + bottomRight;
    }
}
