package part4.atelier;

/**
 * Ателье: одевает мужчину или женщину одеждой из переданного массива.
 * Массив имеет тип Clothes[] - общий суперкласс всех видов одежды.
 */
public class Atelier {

    public void dressWomen(Clothes[] clothes) {
        System.out.println("=== Одеваем женщину ===");
        for (Clothes c : clothes) {
            if (c instanceof WomenClothing) {
                ((WomenClothing) c).dressWomen();
            }
        }
    }

    public void dressMan(Clothes[] clothes) {
        System.out.println("=== Одеваем мужчину ===");
        for (Clothes c : clothes) {
            if (c instanceof MenClothing) {
                ((MenClothing) c).dressMan();
            }
        }
    }
}
