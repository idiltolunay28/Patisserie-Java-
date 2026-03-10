import java.util.ArrayList;

abstract class ColdDrinks {
    protected ArrayList<DrinkAddons> ColdAddons;

    ColdDrinks() {
        this.ColdAddons = new ArrayList<>();
        ColdAddons.add(new Ice());
    }

    public void addAddons(DrinkAddons addon) {
        ColdAddons.add(addon);
    }

    public boolean getIced() {
        return true;
    }

    public abstract double calculatePrice();

    public abstract String getDrinkName();

}

class Frappuccino extends ColdDrinks {
    public double calculatePrice() {
        int price = 30;
        for (DrinkAddons add : ColdAddons) {
            price += add.getCost();
        }
        return price;
    }

    public String getDrinkName() {
        return "Frappuccino";
    }

}

class CoolLime extends ColdDrinks {
    public double calculatePrice() {
        int price = 30;
        for (DrinkAddons add : ColdAddons) {
            price += add.getCost();
        }
        return price;
    }

    public String getDrinkName() {
        return "CoolLime";
    }
}