package part41.transport;

public class Plane extends Transport {

    public Plane(String name) {
        super(name, 800, 180, 20, 6.5, 40.0);
    }

    @Override
    public String getType() {
        return "Самолет";
    }

    @Override
    protected double getExtraTime(double distance) {
        return 2.5; // регистрация, посадка, руление
    }
}
