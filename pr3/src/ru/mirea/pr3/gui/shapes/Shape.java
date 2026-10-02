package ru.mirea.pr3.gui.shapes;

import java.awt.*;

/** Абстрактная фигура: хранит цвет и позицию (левый верхний угол) */
public abstract class Shape {
    protected Color color;
    protected int x;
    protected int y;

    public Shape(Color color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /** Каждая фигура сама знает, как себя нарисовать */
    public abstract void draw(Graphics2D g);

    @Override
    public String toString() {
        return String.format("%-9s x=%3d, y=%3d, цвет=#%06X",
                getClass().getSimpleName(), x, y, color.getRGB() & 0xFFFFFF);
    }
}
