package ru.mirea.pr3.events;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** Задание 4. Калькулятор с кнопками 0-9, '.', '=', '+', '-', '*', '/' */
public class SimpleCalculator extends JFrame {

    private static final String[] KEYS = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
    };

    private final JTextField display = new JTextField("0");

    private double accumulator = 0;     // первый операнд
    private char pendingOp = ' ';       // отложенная операция
    private boolean startNewNumber = true;

    public SimpleCalculator() {
        super("Simple Calculator");
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        display.setBackground(Color.WHITE);

        JPanel keys = new JPanel(new GridLayout(4, 4, 8, 8));
        keys.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        DigitListener digitListener = new DigitListener();
        OperationListener operationListener = new OperationListener();
        for (String key : KEYS) {
            JButton button = new JButton(key);
            if (Character.isDigit(key.charAt(0)) || key.equals(".")) {
                button.addActionListener(digitListener);
            } else {
                button.addActionListener(operationListener);
            }
            keys.add(button);
        }

        JButton clear = new JButton("C");
        // анонимный класс для кнопки сброса
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accumulator = 0;
                pendingOp = ' ';
                startNewNumber = true;
                display.setText("0");
            }
        });
        JPanel bottom = new JPanel(new BorderLayout());
        JLabel caption = new JLabel("Simple Calculator", SwingConstants.CENTER);
        caption.setFont(new Font("Arial", Font.PLAIN, 11));
        caption.setForeground(Color.GRAY);
        bottom.add(caption, BorderLayout.CENTER);
        bottom.add(clear, BorderLayout.EAST);

        setLayout(new BorderLayout());
        add(display, BorderLayout.NORTH);
        add(keys, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);

        setSize(320, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    /** Внутренний класс: ввод цифр и десятичной точки */
    private class DigitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String key = e.getActionCommand();
            if (startNewNumber) {
                display.setText(key.equals(".") ? "0." : key);
                startNewNumber = false;
            } else if (!(key.equals(".") && display.getText().contains("."))) {
                display.setText(display.getText() + key);
            }
        }
    }

    /** Внутренний класс: операции + - * / и = */
    private class OperationListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            char op = e.getActionCommand().charAt(0);
            if (startNewNumber && pendingOp != ' ') {
                // второй операнд еще не введен: повторная операция только заменяет
                // отложенную, а '=' отменяет ее (результат на индикаторе не меняется)
                pendingOp = (op == '=') ? ' ' : op;
                return;
            }
            double value = Double.parseDouble(display.getText());
            if (pendingOp == ' ') {
                accumulator = value;
            } else {
                double before = accumulator;
                accumulator = apply(accumulator, value, pendingOp);
                System.out.println(format(before) + " " + pendingOp + " " + format(value)
                        + " = " + format(accumulator));
            }
            pendingOp = (op == '=') ? ' ' : op;
            display.setText(format(accumulator));
            startNewNumber = true;
        }
    }

    private static double apply(double a, double b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return b == 0 ? Double.NaN : a / b;
            default: return b;
        }
    }

    /** Убирает ".0" у целых чисел */
    private static String format(double x) {
        if (x == Math.rint(x) && !Double.isInfinite(x)) {
            return String.valueOf((long) x);
        }
        return String.valueOf(x);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SimpleCalculator().setVisible(true));
    }
}
