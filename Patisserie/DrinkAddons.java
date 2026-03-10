interface DrinkAddons {
    double getCost();

    String getName();
}

abstract class Crumbs implements DrinkAddons {

    public double getCost() {
        return 0.0;
    }

    public String getName() {
        return "Crumbs";
    }

}

class ChocoCrumbs extends Crumbs {

    public double getCost() {
        return 12.0;
    }

    public String getName() {
        return "ChocoCrumbs";
    }

}