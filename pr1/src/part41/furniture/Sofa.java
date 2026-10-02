package part41.furniture;

public class Sofa extends Furniture {
    private boolean foldable;

    public Sofa(String name, String material, double price, boolean foldable) {
        super(name, material, price);
        this.foldable = foldable;
    }

    @Override
    public String getType() {
        return "Диван";
    }

    @Override
    public String getFeatures() {
        return foldable ? "раскладной" : "нераскладной";
    }
}
