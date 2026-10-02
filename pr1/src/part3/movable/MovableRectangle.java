package part3.movable;

/**
 * Движущийся прямоугольник, заданный двумя движущимися точками:
 * верхней левой и нижней правой. Обе точки должны иметь одинаковую скорость.
 */
public class MovableRectangle implements Movable {
    private MovablePoint topLeft;
    private MovablePoint bottomRight;

    public MovableRectangle(int x1, int y1, int x2, int y2, int xSpeed, int ySpeed) {
        if (x1 >= x2 || y1 <= y2) {
            throw new IllegalArgumentException(
                    "точка (x1,y1) должна быть левее и выше точки (x2,y2)");
        }
        topLeft = new MovablePoint(x1, y1, xSpeed, ySpeed);
        bottomRight = new MovablePoint(x2, y2, xSpeed, ySpeed);
    }

    /** Проверяет, что обе точки движутся с одной и той же скоростью. */
    public boolean hasSameSpeed() {
        return topLeft.xSpeed == bottomRight.xSpeed
                && topLeft.ySpeed == bottomRight.ySpeed;
    }

    private void checkSpeed() {
        if (!hasSameSpeed()) {
            throw new IllegalStateException("скорости точек прямоугольника не совпадают");
        }
    }

    public int getWidth() {
        return bottomRight.x - topLeft.x;
    }

    public int getHeight() {
        return topLeft.y - bottomRight.y;
    }

    @Override
    public void moveUp() {
        checkSpeed();
        topLeft.moveUp();
        bottomRight.moveUp();
    }

    @Override
    public void moveDown() {
        checkSpeed();
        topLeft.moveDown();
        bottomRight.moveDown();
    }

    @Override
    public void moveLeft() {
        checkSpeed();
        topLeft.moveLeft();
        bottomRight.moveLeft();
    }

    @Override
    public void moveRight() {
        checkSpeed();
        topLeft.moveRight();
        bottomRight.moveRight();
    }

    @Override
    public String toString() {
        return "MovableRectangle[topLeft=" + topLeft + ", bottomRight=" + bottomRight
                + ", width=" + getWidth() + ", height=" + getHeight() + "]";
    }
}
