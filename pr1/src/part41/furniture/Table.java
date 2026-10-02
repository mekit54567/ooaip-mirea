package part41.furniture;

public class Table extends Furniture {
    private int seats;

    public Table(String name, String material, double price, int seats) {
        super(name, material, price);
        this.seats = seats;
    }

    @Override
    public String getType() {
        return "Стол";
    }

    @Override
    public String getFeatures() {
        return "мест: " + seats;
    }
}
