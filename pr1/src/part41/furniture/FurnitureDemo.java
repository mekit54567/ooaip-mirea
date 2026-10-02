package part41.furniture;

public class FurnitureDemo {
    public static void main(String[] args) {
        FurnitureShop shop = new FurnitureShop("Уютный дом");
        shop.add(new Chair("Венский", "бук", 4500, false));
        shop.add(new Chair("Офисный Pro", "металл, ткань", 12900, true));
        shop.add(new Table("Обеденный", "дуб", 27500, 6));
        shop.add(new Table("Журнальный", "ЛДСП", 5900, 2));
        shop.add(new Sofa("Честер", "велюр", 64000, false));
        shop.add(new Sofa("Еврокнижка", "рогожка", 38900, true));

        shop.showAll();
        System.out.printf("Стоимость товаров на складе: %.2f руб.%n%n", shop.getStockValue());

        shop.showCheaperThan(10000);
        System.out.println();

        shop.sell("Обеденный");
        shop.sell("Еврокнижка");
        shop.sell("Кресло-качалка");
        System.out.printf("Выручка: %.2f руб.%n", shop.getRevenue());
        System.out.printf("Осталось на складе на сумму: %.2f руб.%n", shop.getStockValue());
    }
}
