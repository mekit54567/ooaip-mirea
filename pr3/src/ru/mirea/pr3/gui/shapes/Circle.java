package ru.mirea.pr3.gui.shapes;

import java.awt.*;

public class Circle extends Shape {
    private final int radius;

    public Circle(Color color, int x, int y, int radius) {
        super(color, x, y);
        this.radius = radius;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(color);
        g.fillOval(x, y, radius * 2, radius * 2);
    }
}
