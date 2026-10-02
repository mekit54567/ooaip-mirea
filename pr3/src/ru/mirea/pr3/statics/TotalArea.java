package ru.mirea.pr3.statics;

/** Пример из теоретической части: массив объектов и сумма площадей */
public class TotalArea {
    public static void main(String[] args) {
        // Объявить массив и создать его
        Circle[] circleArray = createCircleArray();

        // Отобразить circleArray и общую площадь всех кругов
        printCircleArray(circleArray);
    }

    /** Создает массив объектов типа Circle со случайными радиусами */
    public static Circle[] createCircleArray() {
        Circle[] circleArray = new Circle[5];
        for (int i = 0; i < circleArray.length; i++) {
            circleArray[i] = new Circle(Math.random() * 100);
        }
        return circleArray;
    }

    /** Отображает массив кругов и их общую площадь */
    public static void printCircleArray(Circle[] circleArray) {
        System.out.println("Радиус\t\t\tПлощадь");
        for (Circle c : circleArray) {
            System.out.printf("%-16.4f%.4f%n", c.getRadius(), c.getArea());
        }
        System.out.println("----------------------------------------");
        System.out.printf("Общая площадь равна\t%.4f%n", sum(circleArray));
    }

    /** Складывает площади кругов */
    public static double sum(Circle[] circleArray) {
        double sum = 0;
        for (Circle c : circleArray) {
            sum += c.getArea();
        }
        return sum;
    }
}
