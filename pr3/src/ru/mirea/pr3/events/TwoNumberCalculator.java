package ru.mirea.pr3.events;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Задание 1. Калькулятор для двух чисел (по образцу листинга 15.6).
 * Обработчики кнопок реализованы анонимными классами.
 */
public class TwoNumberCalculator extends JFrame {

    private final JTextField firstField = new JTextField(10);
    private final JTextField secondField = new JTextField(10);
    private final JLabel resultLabel = new JLabel("Результат: ");

    public TwoNumberCalculator() {
        super("Калькулятор");
        setLayout(null);   // абсолютное позиционирование, как в листинге 15.6

        JLabel l1 = new JLabel("Число 1:");
        l1.setBounds(20, 20, 70, 25);
        firstField.setBounds(90, 20, 200, 25);
        JLabel l2 = new JLabel("Число 2:");
        l2.setBounds(20, 55, 70, 25);
        secondField.setBounds(90, 55, 200, 25);
        add(l1);
        add(firstField);
        add(l2);
        add(secondField);

        JButton plus = new JButton("+");
        JButton minus = new JButton("-");
        JButton mul = new JButton("*");
        JButton div = new JButton("/");
        JButton[] buttons = {plus, minus, mul, div};
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setBounds(20 + i * 70, 95, 60, 30);
            add(buttons[i]);
        }

        resultLabel.setBounds(20, 140, 280, 25);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(resultLabel);

        // анонимные классы - реализации интерфейса ActionListener
        plus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate('+');
            }
        });
        minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate('-');
            }
        });
        mul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate('*');
            }
        });
        div.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate('/');
            }
        });

        setSize(330, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void calculate(char op) {
        try {
            double x1 = Double.parseDouble(firstField.getText().trim());
            double x2 = Double.parseDouble(secondField.getText().trim());
            double result;
            switch (op) {
                case '+': result = x1 + x2; break;
                case '-': result = x1 - x2; break;
                case '*': result = x1 * x2; break;
                default:
                    if (x2 == 0) {
                        showError("деление на ноль");
                        return;
                    }
                    result = x1 / x2;
            }
            resultLabel.setForeground(Color.BLACK);
            resultLabel.setText("Результат: " + x1 + " " + op + " " + x2 + " = " + result);
            System.out.println(x1 + " " + op + " " + x2 + " = " + result);
        } catch (NumberFormatException e) {
            showError("неверный формат числа");
        }
    }

    private void showError(String message) {
        resultLabel.setForeground(Color.RED);
        resultLabel.setText("Ошибка: " + message);
        System.out.println("Ошибка: " + message);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TwoNumberCalculator().setVisible(true));
    }
}
