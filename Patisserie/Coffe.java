import java.util.ArrayList;
import java.util.Random;

abstract class Coffe implements Orderable {

    protected ArrayList<CoffeAddons> CoAddons;
    protected boolean isIced;

    Coffe(boolean isIced) {
        CoAddons = new ArrayList<>();
        this.isIced = isIced;
    }

    public void addAddons(CoffeAddons addon) {
        CoAddons.add(addon);
    }

    public boolean getIced() {
        return isIced;
    }

    public abstract double calculatePrice();

    public abstract String getCoffeName();

    public boolean checkAddon(Coffe coffe, CoffeAddons addon) {
        if (coffe instanceof Espresso) {
            return ((Espresso) coffe).canAdd(addon);
        } else if (coffe instanceof Latte) {
            return ((Latte) coffe).canAdd(addon);
        } else if (coffe instanceof Americano) {
            return ((Americano) coffe).canAdd(addon);
        } else if (coffe instanceof Macchiato) {
            return ((Macchiato) coffe).canAdd(addon);
        } else {
            return false;
        }
    }

    public void randomizeAddons(Coffe coffe, int addonCount) {
        Random random = new Random();
        int addNo = random.nextInt(6);
        int n = 0;
        while (n < addonCount) {
            switch (addNo) {
                case 0:
                    if (checkAddon(coffe, new WholeMilk())) {
                        addAddons(new WholeMilk());
                    } else {
                        randomizeAddons(coffe, addonCount);
                    }
                    break;
                case 1:
                    if (checkAddon(coffe, new Vanilla())) {
                        addAddons(new Vanilla());
                    } else {
                        randomizeAddons(coffe, addonCount);
                    }
                    break;
                case 2:
                    if (checkAddon(coffe, new Chocolate())) {
                        addAddons(new Chocolate());
                    } else {
                        randomizeAddons(coffe, addonCount);
                    }
                    break;
                case 3:
                    if (checkAddon(coffe, new Caramel())) {
                        addAddons(new Caramel());
                    } else {
                        randomizeAddons(coffe, addonCount);
                    }
                    break;
                case 4:
                    if (checkAddon(coffe, new ExtraShot())) {
                        addAddons(new ExtraShot());
                    } else {
                        randomizeAddons(coffe, addonCount);
                    }
                    break;
                case 5:
                    if (checkAddon(coffe, new Ice())) {
                        addAddons(new Ice());
                    } else {
                        randomizeAddons(coffe, addonCount);
                    }
                    break;
                case 6:
                    if (checkAddon(coffe, new ExtraIce())) {
                        addAddons(new ExtraIce());
                    } else {
                        randomizeAddons(coffe, addonCount);
                    }
                    break;
            }

        }
    }
}

class Espresso extends Coffe {

    private boolean isHeated;

    Espresso(boolean isIced) {
        super(isIced);
        isHeated = false;
    }

    public double calculatePrice() {
        int price = 40;
        for (CoffeAddons add : CoAddons) {
            price += add.getCost();
        }
        return price;
    }

    public boolean canAdd(CoffeAddons addon) {
        if (addon instanceof WholeMilk) {
            return false;
        }
        return true;
    }

    public void heatCup() {
        isHeated = true;
    }

    public boolean getHeat() {
        return isHeated;
    }

    public String getCoffeName() {
        return "Espresso";
    }

}

class Latte extends Coffe {

    Latte(boolean isIced) {
        super(isIced);
        isIced = false;
    }

    public double calculatePrice() {
        int price = 50;
        for (CoffeAddons add : CoAddons) {
            price += add.getCost();
        }
        return price;
    }

    public boolean canAdd(CoffeAddons addon) {
        if (addon instanceof Chocolate || addon instanceof Vanilla || addon instanceof ExtraShot) {
            return false;
        }
        return true;
    }

    public String getCoffeName() {
        return "Latte";
    }

}

class Americano extends Coffe {

    Americano(boolean isIced) {
        super(isIced);
        isIced = false;
    }

    public double calculatePrice() {
        int price = 45;
        for (CoffeAddons add : CoAddons) {
            price += add.getCost();
        }
        return price;
    }

    public boolean canAdd(CoffeAddons addon) {
        if (addon instanceof Vanilla || addon instanceof WholeMilk || addon instanceof ExtraShot) {
            return false;
        }
        return true;
    }

    public String getCoffeName() {
        return "Americano";
    }
}

class Macchiato extends Coffe {

    Macchiato(boolean isIced) {
        super(isIced);
        isIced = false;
    }

    public double calculatePrice() {
        int price = 55;
        for (CoffeAddons add : CoAddons) {
            price += add.getCost();
        }
        return price;
    }

    public boolean canAdd(CoffeAddons addon) {
        if (addon instanceof WholeMilk || addon instanceof Chocolate || addon instanceof ExtraShot) {
            return false;
        }
        return true;
    }

    public String getCoffeName() {
        return "Macchiato";
    }
}
