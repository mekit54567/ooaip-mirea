package part41.furniture;

/**
 * Абстрактная мебель.
 */
public abstract class Furniture {
    protected String name;
    protected String material;
    protected double price;

    public Furniture(String name, String material, double price) {
        this.name = name;
        this.material = material;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    /** Вид мебели (стул, стол, ...). */
    public abstract String getType();

    /** Особенности конкретного вида мебели. */
    public abstract String getFeatures();

    @Override
    public String toString() {
        return String.format("%-6s \"%s\", материал: %s, %s, цена %.2f руб.",
                getType(), name, material, getFeatures(), price);
    }
}
