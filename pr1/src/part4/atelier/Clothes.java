package part4.atelier;

/**
 * Абстрактная одежда: размер, стоимость, цвет.
 */
public abstract class Clothes {
    protected Size size;
    protected double price;
    protected String color;

    public Clothes(Size size, double price, String color) {
        this.size = size;
        this.price = price;
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    /** Название вида одежды. */
    public abstract String getName();

    @Override
    public String toString() {
        return String.format("%-8s размер %-3s (EU %d, %s), цвет: %-7s цена: %.2f руб.",
                getName(), size, size.getEuroSize(), size.getDescription(), color, price);
    }
}
