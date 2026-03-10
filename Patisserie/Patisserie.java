
public class Patisserie {
    public static void main(String[] args) {
    }
}

interface Orderable {

}

interface Drink {

}

class Ice implements CoffeAddons, JuiceAddons, DrinkAddons {

    public double getCost() {
        return 0.0;
    }

    public String getName() {
        return "Ice";
    }
}

class ExtraIce implements CoffeAddons, JuiceAddons, DrinkAddons {
    public double getCost() {
        return 0.5;
    }

    public String getName() {
        return "ExtraIce";
    }
}
