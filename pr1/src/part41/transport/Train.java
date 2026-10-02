package part41.transport;

public class Train extends Transport {

    public Train(String name) {
        super(name, 90, 600, 1500, 2.2, 3.5);
    }

    @Override
    public String getType() {
        return "Поезд";
    }

    @Override
    protected double getExtraTime(double distance) {
        // посадка 0.5 ч и остановки по 15 минут каждые 150 км
        return 0.5 + Math.floor(distance / 150) * 0.25;
    }
}
