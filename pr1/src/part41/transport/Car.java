package part41.transport;

public class Car extends Transport {

    public Car(String name) {
        super(name, 80, 4, 0.5, 5.0, 25.0);
    }

    @Override
    public String getType() {
        return "Автомобиль";
    }

    @Override
    protected double getExtraTime(double distance) {
        // остановка на отдых 0.5 ч на каждые 400 км
        return Math.floor(distance / 400) * 0.5;
    }
}
