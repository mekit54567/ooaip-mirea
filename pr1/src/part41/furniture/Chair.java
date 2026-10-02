package part41.furniture;

public class Chair extends Furniture {
    private boolean hasArmrests;

    public Chair(String name, String material, double price, boolean hasArmrests) {
        super(name, material, price);
        this.hasArmrests = hasArmrests;
    }

    @Override
    public String getType() {
        return "Стул";
    }

    @Override
    public String getFeatures() {
        return hasArmrests ? "с подлокотниками" : "без подлокотников";
    }
}
