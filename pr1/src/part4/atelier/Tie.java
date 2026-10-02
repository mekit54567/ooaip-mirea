package part4.atelier;

public class Tie extends Clothes implements MenClothing {

    public Tie(Size size, double price, String color) {
        super(size, price, color);
    }

    @Override
    public String getName() {
        return "Галстук";
    }

    @Override
    public void dressMan() {
        System.out.println("Мужской   " + this);
    }
}
