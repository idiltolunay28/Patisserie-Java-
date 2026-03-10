import java.util.ArrayList;

interface JuiceAddons {
    public double getCost();

    public String getName();
}

abstract class FruitJuices {

    protected boolean isIced;
    protected ArrayList<JuiceAddons> JuAddons;

    FruitJuices(boolean isIced) {
        this.isIced = isIced;
        JuAddons = new ArrayList<>();
    }

    public void addAddons(JuiceAddons addon) {
        JuAddons.add(addon);
    }

    public boolean getIced() {
        return isIced;
    }

    public abstract double calculatePrice();

    public abstract String getJuiceName();

}

class Lemonade extends FruitJuices {

    private double cost;

    Lemonade(boolean isIced) {
        super(isIced);
        this.cost = 30;
        if (isIced) {
            cost += 1;
        }
    }

    public double calculatePrice() {
        for (JuiceAddons add : JuAddons) {
            cost += add.getCost();
        }
        return cost;
    }

    public String getJuiceName() {
        return "Lemonade";
    }

}

class OrangeJuice extends FruitJuices {

    private double cost;

    OrangeJuice(boolean isIced) {
        super(isIced);
        this.cost = 25;
        if (isIced) {
            cost += 1;
        }
    }

    public double calculatePrice() {
        for (JuiceAddons add : JuAddons) {
            cost += add.getCost();
        }
        return cost;
    }

    public String getJuiceName() {
        return "Orange Juice";
    }
}

class AppleJuice extends FruitJuices {

    private double cost;

    AppleJuice(boolean isIced) {
        super(isIced);
        this.cost = 32;
        if (isIced) {
            cost += 1;
        }
    }

    public double calculatePrice() {
        for (JuiceAddons add : JuAddons) {
            cost += add.getCost();
        }
        return cost;
    }

    public String getJuiceName() {
        return "Apple Juice";
    }
}