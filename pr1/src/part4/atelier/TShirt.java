package part4.atelier;

public class TShirt extends Clothes implements MenClothing, WomenClothing {

    public TShirt(Size size, double price, String color) {
        super(size, price, color);
    }

    @Override
    public String getName() {
        return "Футболка";
    }

    @Override
    public void dressMan() {
        System.out.println("Мужская   " + this);
    }

    @Override
    public void dressWomen() {
        System.out.println("Женская   " + this);
    }
}
