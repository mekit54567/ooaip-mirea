package ru.mirea.pr3.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/** Задание 3. Показывает картинку, путь к которой передан в аргументах командной строки */
public class ImageViewer extends JFrame {

    public ImageViewer(BufferedImage image, String name) {
        super("Просмотр: " + name);
        JLabel label = new JLabel(new ImageIcon(image));
        add(new JScrollPane(label));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Использование: java ru.mirea.pr3.gui.ImageViewer <путь к картинке>");
            return;
        }
        File file = new File(args[0]);
        try {
            BufferedImage image = ImageIO.read(file);
            if (image == null) {
                System.out.println("Файл не является изображением: " + file);
                return;
            }
            System.out.println("Загружено изображение " + file.getName() + " размером "
                    + image.getWidth() + "x" + image.getHeight());
            SwingUtilities.invokeLater(() -> new ImageViewer(image, file.getName()).setVisible(true));
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }
    }
}
