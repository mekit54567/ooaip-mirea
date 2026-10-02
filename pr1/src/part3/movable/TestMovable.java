package part3.movable;

/**
 * Тестовый класс к заданию 2: MovablePoint, MovableCircle, MovableRectangle.
 */
public class TestMovable {
    public static void main(String[] args) {
        Movable m1 = new MovablePoint(5, 6, 10, 15);   // upcast к интерфейсу
        System.out.println("Точка:          " + m1);
        m1.moveLeft();
        System.out.println("moveLeft():     " + m1);
        m1.moveUp();
        System.out.println("moveUp():       " + m1);

        Movable m2 = new MovableCircle(1, 2, 3, 4, 20);
        System.out.println("Круг:           " + m2);
        m2.moveRight();
        System.out.println("moveRight():    " + m2);
        m2.moveDown();
        System.out.println("moveDown():     " + m2);

        MovableRectangle rect = new MovableRectangle(0, 10, 8, 4, 2, 3);
        System.out.println("Прямоугольник:  " + rect);
        System.out.println("Скорости точек совпадают: " + rect.hasSameSpeed());
        rect.moveRight();
        rect.moveUp();
        System.out.println("moveRight(), moveUp(): " + rect);
        rect.moveLeft();
        rect.moveDown();
        rect.moveDown();
        System.out.println("moveLeft(), 2 x moveDown(): " + rect);

        // Все объекты обрабатываются единообразно через интерфейс Movable
        System.out.println("--- Массив Movable[]: каждый объект сдвигаем вправо ---");
        Movable[] objects = {m1, m2, rect};
        for (Movable m : objects) {
            m.moveRight();
            System.out.println(m);
        }

        try {
            new MovableRectangle(10, 0, 0, 10, 1, 1);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка создания: " + e.getMessage());
        }
    }
}
