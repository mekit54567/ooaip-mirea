package ru.mirea.pr3.events;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** Задание 2. Выбор страны из выпадающего списка JComboBox и вывод информации о ней */
public class CountryChooser extends JFrame {

    /** Статический вложенный класс - описание страны */
    public static class Country {
        private final String name;
        private final String capital;
        private final String population;
        private final String language;

        public Country(String name, String capital, String population, String language) {
            this.name = name;
            this.capital = capital;
            this.population = population;
            this.language = language;
        }

        public String getInfo() {
            return "Страна: " + name + "\nСтолица: " + capital
                    + "\nНаселение: " + population + "\nЯзык: " + language;
        }

        @Override
        public String toString() {
            return name;   // так страна отображается в JComboBox
        }
    }

    private final JComboBox<Country> comboBox;
    private final JTextArea infoArea = new JTextArea(5, 28);

    public CountryChooser() {
        super("Hello Swing");
        Country[] countries = {
                new Country("Australia", "Канберра", "около 27 млн чел.", "английский"),
                new Country("China", "Пекин", "около 1,4 млрд чел.", "китайский"),
                new Country("England", "Лондон", "около 57 млн чел.", "английский"),
                new Country("Russia", "Москва", "около 146 млн чел.", "русский")
        };
        comboBox = new JComboBox<>(countries);
        infoArea.setEditable(false);
        infoArea.setFont(new Font("Arial", Font.PLAIN, 14));

        // обработчик выбора пункта - внутренний класс
        comboBox.addActionListener(new SelectionListener());

        setLayout(new BorderLayout(5, 5));
        add(comboBox, BorderLayout.NORTH);
        add(new JScrollPane(infoArea), BorderLayout.CENTER);
        showCountry((Country) comboBox.getSelectedItem());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    /** Внутренний (нестатический) класс: имеет доступ к полям CountryChooser */
    private class SelectionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Country selected = (Country) comboBox.getSelectedItem();
            showCountry(selected);
            System.out.println("Выбрана страна: " + selected);
        }
    }

    private void showCountry(Country country) {
        infoArea.setText(country.getInfo());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CountryChooser().setVisible(true));
    }
}
