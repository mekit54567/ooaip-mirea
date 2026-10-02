package part4.seasons;

/**
 * Перечисление времён года со средней температурой.
 */
public enum Season {
    WINTER("Зима", -8.5),
    SPRING("Весна", 6.0),
    SUMMER("Лето", 18.5) {
        // для лета описание переопределено
        @Override
        public String getDescription() {
            return "Теплое время года";
        }
    },
    AUTUMN("Осень", 5.5);

    private final String russianName;
    private final double averageTemperature;

    Season(String russianName, double averageTemperature) {
        this.russianName = russianName;
        this.averageTemperature = averageTemperature;
    }

    public String getRussianName() {
        return russianName;
    }

    public double getAverageTemperature() {
        return averageTemperature;
    }

    public String getDescription() {
        return "Холодное время года";
    }
}
