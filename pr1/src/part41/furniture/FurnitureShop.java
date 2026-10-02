package part41.furniture;

import java.util.ArrayList;
import java.util.List;

/**
 * Магазин мебели: ассортимент, поиск, продажа.
 */
public class FurnitureShop {
    private final String title;
    private final List<Furniture> stock = new ArrayList<>();
    private double revenue;

    public FurnitureShop(String title) {
        this.title = title;
    }

    public void add(Furniture item) {
        stock.add(item);
    }

    public void showAll() {
        System.out.println("Ассортимент магазина \"" + title + "\":");
        for (int i = 0; i < stock.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + stock.get(i));
        }
    }

    public void showCheaperThan(double maxPrice) {
        System.out.printf("Мебель дешевле %.0f руб.:%n", maxPrice);
        for (Furniture f : stock) {
            if (f.getPrice() < maxPrice) {
                System.out.println("  " + f);
            }
        }
    }

    /** Продажа товара по названию. */
    public boolean sell(String name) {
        for (Furniture f : stock) {
            if (f.getName().equals(name)) {
                stock.remove(f);
                revenue += f.getPrice();
                System.out.println("Продано: " + f.getType() + " \"" + name + "\"");
                return true;
            }
        }
        System.out.println("Товар \"" + name + "\" не найден");
        return false;
    }

    public double getStockValue() {
        double sum = 0;
        for (Furniture f : stock) {
            sum += f.getPrice();
        }
        return sum;
    }

    public double getRevenue() {
        return revenue;
    }
}
