package part41.transport;

public class Ship extends Transport {

    public Ship(String name) {
        super(name, 30, 300, 5000, 3.0, 1.2);
    }

    @Override
    public String getType() {
        return "Корабль";
    }

    @Override
    protected double getExtraTime(double distance) {
        return 4.0; // погрузка и выгрузка в порту
    }
}
