package ru.mirea.pr3.gui;

import ru.mirea.pr3.gui.shapes.Circle;
import ru.mirea.pr3.gui.shapes.Rectangle;
import ru.mirea.pr3.gui.shapes.Shape;
import ru.mirea.pr3.gui.shapes.Triangle;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/** Задание 2. Окно с 20 случайными фигурами случайного цвета */
public class RandomShapesFrame extends JFrame {

    private static final int COUNT = 20;
    private static final int CANVAS_WIDTH = 600;
    private static final int CANVAS_HEIGHT = 450;

    private final Shape[] shapes = new Shape[COUNT];
    private final Random random;

    public RandomShapesFrame(long seed) {
        super("20 случайных фигур");
        random = new Random(seed);
        generateShapes();

        // панель-холст, на которой рисуются все фигуры
        JPanel canvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                for (Shape s : shapes) {
                    s.draw(g2);
                }
            }
        };
        canvas.setBackground(Color.WHITE);
        canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));

        add(canvas);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    private void generateShapes() {
        for (int i = 0; i < COUNT; i++) {
            Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            int x = random.nextInt(CANVAS_WIDTH - 100);
            int y = random.nextInt(CANVAS_HEIGHT - 100);
            switch (random.nextInt(3)) {
                case 0:
                    shapes[i] = new Circle(color, x, y, 15 + random.nextInt(35));
                    break;
                case 1:
                    shapes[i] = new Rectangle(color, x, y, 20 + random.nextInt(80), 20 + random.nextInt(80));
                    break;
                default:
                    shapes[i] = new Triangle(color, x, y, 30 + random.nextInt(70));
            }
            System.out.printf("%2d: %s%n", i + 1, shapes[i]);
        }
    }

    public static void main(String[] args) {
        // seed можно передать аргументом, чтобы картинка повторялась
        long seed = args.length > 0 ? Long.parseLong(args[0]) : System.currentTimeMillis();
        SwingUtilities.invokeLater(() -> new RandomShapesFrame(seed).setVisible(true));
    }
}
