package ru.mirea.pr3.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Задание 4. Анимация по картинке-спрайту: картинка состоит из нескольких
 * кадров одинаковой ширины, расположенных в одну строку.
 */
public class AnimationFrame extends JFrame {

    private final BufferedImage[] frames;
    private int current = 0;

    public AnimationFrame(BufferedImage sprite, int frameCount, int delayMs) {
        super("Анимация (" + frameCount + " кадров)");
        frames = cutFrames(sprite, frameCount);

        JPanel canvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                BufferedImage img = frames[current];
                int x = (getWidth() - img.getWidth()) / 2;
                int y = (getHeight() - img.getHeight()) / 2;
                g.drawImage(img, x, y, null);
                g.setColor(Color.DARK_GRAY);
                g.drawString("Кадр " + (current + 1) + " из " + frames.length, 10, getHeight() - 10);
            }
        };
        canvas.setBackground(Color.WHITE);
        canvas.setPreferredSize(new Dimension(frames[0].getWidth() + 160, frames[0].getHeight() + 60));
        add(canvas);

        // таймер Swing переключает кадры в потоке обработки событий
        Timer timer = new Timer(delayMs, e -> {
            current = (current + 1) % frames.length;
            canvas.repaint();
        });
        timer.start();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    /** Разрезает спрайт на frameCount кадров */
    private static BufferedImage[] cutFrames(BufferedImage sprite, int frameCount) {
        int w = sprite.getWidth() / frameCount;
        BufferedImage[] result = new BufferedImage[frameCount];
        for (int i = 0; i < frameCount; i++) {
            result[i] = sprite.getSubimage(i * w, 0, w, sprite.getHeight());
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        String path = args.length > 0 ? args[0] : "res/sprite.png";
        int count = args.length > 1 ? Integer.parseInt(args[1]) : 8;
        BufferedImage sprite = ImageIO.read(new File(path));
        System.out.println("Спрайт " + sprite.getWidth() + "x" + sprite.getHeight()
                + " разрезан на " + count + " кадров по " + sprite.getWidth() / count + " px");
        SwingUtilities.invokeLater(() -> new AnimationFrame(sprite, count, 120).setVisible(true));
    }
}
