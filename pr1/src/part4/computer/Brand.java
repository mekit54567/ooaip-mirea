package part4.computer;

/**
 * Марки компьютеров.
 */
public enum Brand {
    APPLE("США"),
    LENOVO("Китай"),
    ASUS("Тайвань"),
    HP("США"),
    DELL("США"),
    ACER("Тайвань");

    private final String country;

    Brand(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }
}
