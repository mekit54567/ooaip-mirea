package part41.transport;

/**
 * Абстрактное транспортное средство.
 */
public abstract class Transport {
    protected String name;
    protected double speed;            // средняя скорость, км/ч
    protected int passengerCapacity;   // мест за один рейс
    protected double cargoCapacity;    // грузоподъемность, т
    protected double passengerRate;    // руб. за 1 пассажиро-километр
    protected double cargoRate;        // руб. за 1 тонно-километр

    public Transport(String name, double speed, int passengerCapacity, double cargoCapacity,
                     double passengerRate, double cargoRate) {
        this.name = name;
        this.speed = speed;
        this.passengerCapacity = passengerCapacity;
        this.cargoCapacity = cargoCapacity;
        this.passengerRate = passengerRate;
        this.cargoRate = cargoRate;
    }

    public abstract String getType();

    /** Дополнительное время на рейс (посадка, погрузка, остановки), ч. */
    protected abstract double getExtraTime(double distance);

    /** Время одного рейса, ч. */
    public double getTripTime(double distance) {
        return distance / speed + getExtraTime(distance);
    }

    /** Время обратного (порожнего) пробега к месту погрузки, ч: только движение, без доп. времени. */
    public double getReturnTime(double distance) {
        return distance / speed;
    }

    /**
     * Общее время перевозки, ч. Предположения модели: используется одно транспортное средство;
     * после каждого рейса, кроме последнего, оно возвращается порожним к месту погрузки.
     */
    public double getTotalTime(double distance, int trips) {
        return trips * getTripTime(distance) + (trips - 1) * getReturnTime(distance);
    }

    /** Сколько рейсов нужно, чтобы перевезти всех пассажиров и весь груз. */
    public int getTripsCount(int passengers, double cargo) {
        int byPassengers = (int) Math.ceil((double) passengers / passengerCapacity);
        int byCargo = (int) Math.ceil(cargo / cargoCapacity);
        return Math.max(1, Math.max(byPassengers, byCargo));
    }

    public double getPassengerCost(double distance, int passengers) {
        return distance * passengers * passengerRate;
    }

    public double getCargoCost(double distance, double cargo) {
        return distance * cargo * cargoRate;
    }

    /** Печать расчета перевозки. */
    public void printReport(double distance, int passengers, double cargo) {
        int trips = getTripsCount(passengers, cargo);
        double time = getTotalTime(distance, trips);
        double cost = getPassengerCost(distance, passengers) + getCargoCost(distance, cargo);
        System.out.printf("%-10s %-18s рейсов: %3d, время: %7.1f ч, стоимость: %12.2f руб.%n",
                getType(), name, trips, time, cost);
    }
}
