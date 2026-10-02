package ru.mirea.pr3.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Задание 1. Табло результатов матча AC Milan - Real Madrid.
 * Каждое нажатие на кнопку команды добавляет ей один гол.
 */
public class MatchScoreboard extends JFrame {

    private static final String MILAN = "AC Milan";
    private static final String MADRID = "Real Madrid";

    private int milanScore = 0;
    private int madridScore = 0;

    private final JLabel resultLabel = new JLabel("Result: 0 X 0", SwingConstants.CENTER);
    private final JLabel lastScorerLabel = new JLabel("Last Scorer: N/A", SwingConstants.CENTER);
    private final JLabel winnerLabel = new JLabel("Winner: DRAW", SwingConstants.CENTER);

    public MatchScoreboard() {
        super("Milan vs Madrid");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton milanButton = new JButton(MILAN);
        JButton madridButton = new JButton(MADRID);

        // обработчики нажатий: увеличиваем счет нужной команды
        milanButton.addActionListener(e -> {
            milanScore++;
            updateBoard(MILAN);
        });
        madridButton.addActionListener(e -> {
            madridScore++;
            updateBoard(MADRID);
        });

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttons.add(milanButton);
        buttons.add(madridButton);

        Font font = new Font("Arial", Font.BOLD, 18);
        resultLabel.setFont(font);
        lastScorerLabel.setFont(font.deriveFont(Font.PLAIN, 16f));
        winnerLabel.setFont(font.deriveFont(Font.PLAIN, 16f));

        JPanel info = new JPanel(new GridLayout(3, 1, 5, 5));
        info.add(resultLabel);
        info.add(lastScorerLabel);
        info.add(winnerLabel);

        setLayout(new BorderLayout());
        add(buttons, BorderLayout.NORTH);
        add(info, BorderLayout.CENTER);
        setSize(360, 220);
        setLocationRelativeTo(null);
    }

    /** Обновляет все надписи после очередного гола */
    private void updateBoard(String scorer) {
        resultLabel.setText("Result: " + milanScore + " X " + madridScore);
        lastScorerLabel.setText("Last Scorer: " + scorer);
        String winner;
        if (milanScore > madridScore) {
            winner = MILAN;
        } else if (madridScore > milanScore) {
            winner = MADRID;
        } else {
            winner = "DRAW";
        }
        winnerLabel.setText("Winner: " + winner);
        System.out.println("Гол забила команда " + scorer + ". Счет " + milanScore + " X " + madridScore
                + ", Winner: " + winner);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MatchScoreboard().setVisible(true));
    }
}
