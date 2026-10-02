package dop.stock;

/**
 * Клиент класса Stock.
 */
public class TestStock {
    public static void main(String[] args) {
        Stock stock = new Stock("SBER", "ПАО Сбербанк");
        stock.previousClosingPrice = 281.50;
        stock.currentPrice = 282.87;

        System.out.println("Акции: " + stock.symbol + " (" + stock.name + ")");
        System.out.printf("Цена закрытия предыдущего дня: %.2f%n", stock.previousClosingPrice);
        System.out.printf("Текущая цена: %.2f%n", stock.currentPrice);
        System.out.printf("Изменение стоимости: %+.2f%%%n", stock.getChangePercent());
    }
}
