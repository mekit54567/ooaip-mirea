package ru.mirea.pr3.statics;

import java.util.Random;

/** Задание 5. Массив объектов Circle и поиск круга с наибольшей площадью */
public class LargestCircle {

    public static void main(String[] args) {
        Random random = new Random(15);
        Circle[] circles = new Circle[8];
        for (int i = 0; i < circles.length; i++) {
            circles[i] = new Circle(1 + random.nextInt(200) / 10.0);
        }

        System.out.println("Массив кругов:");
        for (int i = 0; i < circles.length; i++) {
            System.out.println("  [" + i + "] " + circles[i]);
        }

        int index = findLargest(circles);
        System.out.println("Круг с самой большой площадью: [" + index + "] " + circles[index]);
        System.out.println("Всего создано объектов Circle: " + Circle.getNumberOfObjects());
    }

    /** Возвращает индекс круга с максимальной площадью */
    public static int findLargest(Circle[] circles) {
        int maxIndex = 0;
        for (int i = 1; i < circles.length; i++) {
            if (circles[i].getArea() > circles[maxIndex].getArea()) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
