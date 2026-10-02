package part4.atelier;

/**
 * Задание 2 (ПР4). Ателье.
 */
public class AtelierDemo {
    public static void main(String[] args) {
        System.out.println("Размеры одежды:");
        for (Size s : Size.values()) {
            System.out.println("  " + s + " - EU " + s.getEuroSize() + ", " + s.getDescription());
        }
        System.out.println();

        Clothes[] clothes = {
                new TShirt(Size.S, 1290.0, "белая"),
                new TShirt(Size.XXS, 590.0, "желтая"),
                new Pants(Size.M, 3490.0, "черные"),
                new Pants(Size.XS, 2990.0, "синие"),
                new Skirt(Size.S, 2490.0, "красная"),
                new Tie(Size.L, 990.0, "бордовый")
        };

        Atelier atelier = new Atelier();
        atelier.dressMan(clothes);
        System.out.println();
        atelier.dressWomen(clothes);
    }
}
