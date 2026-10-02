package ru.mirea.pr3.gui.shapes;

import java.awt.*;

/** Равнобедренный треугольник, вписанный в квадрат size x size */
public class Triangle extends Shape {
    private final int size;

    public Triangle(Color color, int x, int y, int size) {
        super(color, x, y);
        this.size = size;
    }

    @Override
    public void draw(Graphics2D g) {
        int[] xs = {x, x + size / 2, x + size};
        int[] ys = {y + size, y, y + size};
        g.setColor(color);
        g.fillPolygon(xs, ys, 3);
    }
}
