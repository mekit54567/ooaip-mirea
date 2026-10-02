package part4.shop;

import java.util.ArrayList;
import java.util.List;

/**
 * Корзина покупателя.
 */
public class Cart {
    private final List<Product> items = new ArrayList<>();

    public void add(Product product) {
        items.add(product);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public double getTotal() {
        double total = 0;
        for (Product p : items) {
            total += p.getPrice();
        }
        return total;
    }

    public void print() {
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
            return;
        }
        System.out.println("Товары в корзине:");
        for (int i = 0; i < items.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + items.get(i));
        }
        System.out.printf("  Итого: %.2f руб.%n", getTotal());
    }

    public void clear() {
        items.clear();
    }
}
