package ru.mirea.pr6.computershop;

/** Марки компьютеров. */
public enum Brand {
    APPLE("Apple"),
    ASUS("ASUS"),
    LENOVO("Lenovo"),
    HP("HP"),
    DELL("Dell"),
    ACER("Acer"),
    MSI("MSI");

    private final String title;

    Brand(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    /** Поиск марки по названию без учета регистра. */
    public static Brand fromString(String s) {
        for (Brand b : values()) {
            if (b.title.equalsIgnoreCase(s.trim())) {
                return b;
            }
        }
        throw new IllegalArgumentException("Неизвестная марка: " + s);
    }
}
