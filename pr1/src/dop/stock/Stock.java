package dop.stock;

/**
 * Акции компании.
 */
public class Stock {
    String symbol;               // обозначение акций
    String name;                 // наименование
    double previousClosingPrice; // цена закрытия предыдущего дня
    double currentPrice;         // текущая цена

    /** Акции с указанными обозначением и наименованием. */
    Stock(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

    /** Процент изменения стоимости с previousClosingPrice на currentPrice. */
    double getChangePercent() {
        return (currentPrice - previousClosingPrice) / previousClosingPrice * 100;
    }
}
