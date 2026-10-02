package ru.mirea.pr3.events;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/** Задание 3. Окно с меню «Файл» / «Правка» / «Справка», двумя кнопками и полем ввода текста */
public class MenuEditor extends JFrame {

    private static final Path SAVE_FILE = Paths.get("saved_text.txt");

    private final JTextArea textArea = new JTextArea("This is the area you can write text.", 6, 30);

    public MenuEditor() {
        super("Hello Swing");
        setJMenuBar(createMenuBar());

        // панель с двумя кнопками, GridLayout: 1 строка, 2 столбца
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        buttonPanel.add(button1);
        buttonPanel.add(button2);

        button1.addActionListener(e -> {
            textArea.append("\nНажата кнопка Button 1");
            System.out.println("Button 1");
        });
        button2.addActionListener(e -> {
            textArea.setText("");
            System.out.println("Button 2: текст очищен");
        });

        textArea.setLineWrap(true);
        setLayout(new BorderLayout());
        add(buttonPanel, BorderLayout.NORTH);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu file = new JMenu("Файл");
        file.add(createItem("Сохранить", new SaveAction()));
        file.add(createItem("Выйти", e -> System.exit(0)));

        JMenu edit = new JMenu("Правка");
        edit.add(createItem("Копировать", e -> textArea.copy()));
        edit.add(createItem("Вырезать", e -> textArea.cut()));
        edit.add(createItem("Вставить", e -> textArea.paste()));

        JMenu help = new JMenu("Справка");
        help.add(createItem("О программе", e -> JOptionPane.showMessageDialog(this,
                "Практическая работа: меню, кнопки и текстовое поле", "О программе",
                JOptionPane.INFORMATION_MESSAGE)));

        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(help);
        return menuBar;
    }

    private JMenuItem createItem(String text, ActionListener listener) {
        JMenuItem item = new JMenuItem(text);
        item.addActionListener(listener);
        return item;
    }

    /** Внутренний класс-обработчик пункта меню «Сохранить»: сохраняет текст в файл */
    private class SaveAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Files.write(SAVE_FILE, textArea.getText().getBytes(StandardCharsets.UTF_8));
                System.out.println("Текст сохранен в файл " + SAVE_FILE.toAbsolutePath().getFileName()
                        + " (" + textArea.getText().length() + " символов)");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(MenuEditor.this, "Ошибка сохранения: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MenuEditor().setVisible(true));
    }
}
