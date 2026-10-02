package part4.atelier;

public class Pants extends Clothes implements MenClothing, WomenClothing {

    public Pants(Size size, double price, String color) {
        super(size, price, color);
    }

    @Override
    public String getName() {
        return "Штаны";
    }

    @Override
    public void dressMan() {
        System.out.println("Мужские   " + this);
    }

    @Override
    public void dressWomen() {
        System.out.println("Женские   " + this);
    }
}
