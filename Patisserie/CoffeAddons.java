interface CoffeAddons {
    double getCost();

    String getName();
}

class WholeMilk implements CoffeAddons {
    public double getCost() {
        return 2.0;
    }

    public String getName() {
        return "Whole Milk";
    }
}

class AlmondMilk extends WholeMilk {
    public double getCost() {
        return 5.0;
    }

    public String getName() {
        return "Almond Milk";
    }
}

class SoyMilk extends WholeMilk {
    public double getCost() {
        return 7.0;
    }

    public String getName() {
        return "Soy Milk";
    }
}

class OatMilk extends WholeMilk {
    public double getCost() {
        return 4.0;
    }

    public String getName() {
        return "Oat Milk";
    }
}

class Vanilla implements CoffeAddons {
    public double getCost() {
        return 6.0;
    }

    public String getName() {
        return "Vanilla";
    }
}

class Chocolate implements CoffeAddons {
    public double getCost() {
        return 6.5;
    }

    public String getName() {
        return "Chocolate";
    }
}

class Caramel implements CoffeAddons {
    public double getCost() {
        return 5.5;
    }

    public String getName() {
        return "Caramel";
    }
}

class ExtraShot implements CoffeAddons {
    public double getCost() {
        return 7.0;
    }

    public String getName() {
        return "ExtraShot";
    }
}
