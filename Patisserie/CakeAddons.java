interface CakeAddons {
    double getCost();

    String getName();
}

class Candle implements CakeAddons {
    public double getCost() {
        return 10;
    }

    public String getName() {
        return "Candle";
    }
}

class Writing implements CakeAddons {
    private String writing;

    Writing(String text) {
        this.writing = text;
    }

    public double getCost() {
        return 0;
    }

    public String getName() {
        return "Writing";
    }

    public String getWriting() {
        return writing;
    }

}

// Flavor //
abstract class Flavour implements CakeAddons {
    public double getCost() {
        return 0;
    }

    public String getName() {
        return "Flavour";
    }
}

class VanillaFlavour extends Flavour {
    public double getCost() {
        return 20;
    }

    public String getName() {
        return "VanillaFlavuor";
    }
}

class ChocoFlavour extends Flavour {
    public double getCost() {
        return 25;
    }

    public String getName() {
        return "ChocoFlavour";
    }
}

class MatchaFlavour extends Flavour {
    public double getCost() {
        return 45;
    }

    public String getName() {
        return "MatchaFlavour";
    }
}

class PlainFlavour extends Flavour {
    public double getCost() {
        return 10;
    }

    public String getName() {
        return "PlainFlavour";
    }
}

// Sprinkles //
abstract class Sprinkles implements CakeAddons {
    public double getCost() {
        return 0;
    }

    public String getName() {
        return "Sprinkles";
    }
}

class ChocoSprinkles extends Sprinkles {
    public double getCost() {
        return 10;
    }

    public String getName() {
        return "ChocoSprinkles";
    }
}

class RainbowSprinkles extends Sprinkles {
    public double getCost() {
        return 12;
    }

    public String getName() {
        return "RainbowSprinkles";
    }
}

class CoconutSprinkles extends Sprinkles {
    public double getCost() {
        return 16;
    }

    public String getName() {
        return "CoconutSprinkles";
    }
}

class MatchaSprinkles extends Sprinkles {
    public double getCost() {
        return 20;
    }

    public String getName() {
        return "MatchaSprinkles";
    }
}

// Filling //
abstract class Filling implements CakeAddons {
    public double getCost() {
        return 0;
    }

    public String getName() {
        return "Filling";
    }
}

class FruitFilling extends Filling {
    public double getCost() {
        return 14;
    }

    public String getName() {
        return "FruitFilling";
    }
}

class Ganache extends Filling { // Choco Filling
    public double getCost() {
        return 16;
    }

    public String getName() {
        return "Ganache";
    }
}

class Curds extends Filling { // Lemon/Lime Filling
    public double getCost() {
        return 18;
    }

    public String getName() {
        return "Curds";
    }
}

class CaramelFilling extends Filling {
    public double getCost() {
        return 14;
    }

    public String getName() {
        return "CaramelFilling";
    }
}

class ButterCream extends Filling { // Plain Filling
    public double getCost() {
        return 10;
    }

    public String getName() {
        return "ButerCream";
    }
}

class VanillaFilling extends Filling {
    public double getCost() {
        return 12;
    }

    public String getName() {
        return "VanillaFilling";
    }
}

// Sauces //
abstract class Sauce implements CakeAddons {
    public double getCost() {
        return 0;
    }

    public String getName() {
        return "Sauce";
    }
}

class LemonSauce extends Sauce {
    public double getCost() {
        return 12;
    }

    public String getName() {
        return "LemonSauce";
    }
}

class RaspberrySauce extends Sauce {
    public double getCost() {
        return 16;
    }

    public String getName() {
        return "RaspberrySauce";
    }
}

class ChocoSauce extends Sauce {
    public double getCost() {
        return 10;
    }

    public String getName() {
        return "ChocoSauce";
    }
}

class CaramelSauce extends Sauce {
    public double getCost() {
        return 10;
    }

    public String getName() {
        return "CaramelSauce";
    }
}

class WalnutSauce extends Sauce {
    public double getCost() {
        return 14;
    }

    public String getName() {
        return "WalnutSauce";
    }
}

// Drizzle //
abstract class Drizzle implements CakeAddons, DrinkAddons {
    public double getCost() {
        return 0;
    }

    public String getName() {
        return "Drizzle";
    }
}

class ChocoDrizlle extends Drizzle {
    public double getCost() {
        return 8;
    }

    public String getName() {
        return "ChocoDrizzle";
    }
}

class FruitDrizzle extends Drizzle {
    public double getCost() {
        return 10;
    }

    public String getName() {
        return "FruitDrizzle";
    }
}

class CaramelDrizzle extends Drizzle {
    public double getCost() {
        return 8;
    }

    public String getName() {
        return "CaramelDrizzle";
    }
}

class ColoredDrizzle extends Drizzle {
    private String Color;

    ColoredDrizzle(String color) {
        this.Color = color;
    }

    public double getCost() {
        return 15;
    }

    public String getName() {
        return "ColoredDrizzle";
    }

    public String getColor() {
        return Color.toLowerCase();
    }
}

// Decorations //
abstract class Decorations implements CakeAddons {
    public double getCost() {
        return 0;
    }

    public String getName() {
        return "Decorations";
    }
}

class Brittle extends Decorations {
    public double getCost() {
        return 20;
    }

    public String getName() {
        return "Brittle";
    }
}

class WholeFruits extends Decorations {
    public double getCost() {
        return 18;
    }

    public String getName() {
        return "WholeFruits";
    }
}

class Flowers extends Decorations {
    private int amount;

    Flowers(int amount) {
        this.amount = amount;
    }

    public double getCost() {
        return amount * 10;
    }

    public String getName() {
        return "Flowers";
    }
}

class GumDrop extends Decorations { // Jelibon
    public double getCost() {
        return 18;
    }

    public String getName() {
        return "GumDrop";
    }
}