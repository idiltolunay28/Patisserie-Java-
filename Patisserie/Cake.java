import java.util.ArrayList;
import java.util.Random;

abstract class Cake {
    protected ArrayList<CakeAddons> CaAddons;
    protected int Tier;

    Cake(int tier) {
        CaAddons = new ArrayList<>();
        this.Tier = tier;
    }

    public void addAddons(CakeAddons addon) {
        CaAddons.add(addon);
    }

    public abstract double calculatePrice();

    public abstract String getCakeName();

    public boolean checkAddon(Cake cake, CakeAddons addon) {
        if (cake instanceof TieredCake) {
            return ((TieredCake) cake).canAdd(addon);
        } else if (cake instanceof CheeseCake) {
            return ((CheeseCake) cake).canAdd(addon);
        } else if (cake instanceof CupCake) {
            return ((CupCake) cake).canAdd(addon);
        } else if (cake instanceof Brownie) {
            return ((Brownie) cake).canAdd(addon);
        } else {
            return false;
        }
    }

    public void randomizeAddons(Cake cake, int addonCount) {
        Random random = new Random();
        int addNo = random.nextInt(6);
        int n = 0;
        while (n < addonCount) {
            switch (addNo) {
                case 0:
                    if (checkAddon(cake, new ChocoFlavour()))
                        addAddons(randomizeFlavour());
                    else {
                        randomizeAddons(cake, addonCount);
                    }
                    break;
                case 1:
                    if (checkAddon(cake, new ChocoSprinkles())) {
                        addAddons(randomizeSprinkles());
                    } else {
                        randomizeAddons(cake, addonCount);
                    }
                    break;
                case 2:
                    if (checkAddon(cake, new ButterCream())) {
                        addAddons(randomizeFilling());
                    } else {
                        randomizeAddons(cake, addonCount);
                    }
                    break;
                case 3:
                    if (checkAddon(cake, new ChocoSauce())) {
                        addAddons(randomizeSauce());
                    } else {
                        randomizeAddons(cake, addonCount);
                    }
                    break;
                case 4:
                    if (checkAddon(cake, new ChocoDrizlle())) {
                        addAddons(randomizeDrizzle());
                    } else {
                        randomizeAddons(cake, addonCount);
                    }
                    break;
                case 5:
                    if (checkAddon(cake, new Brittle())) {
                        addAddons(randomizeDecorations());
                    } else {
                        randomizeAddons(cake, addonCount);
                    }
                    break;
            }
            n++;
        }
    }

    public Flavour randomizeFlavour() {
        Random random = new Random();
        int flavour = random.nextInt(3);
        switch (flavour) {
            case 0:
                return new VanillaFlavour();
            case 1:
                return new ChocoFlavour();
            case 2:
                return new MatchaFlavour();
            case 3:
                return new PlainFlavour();

        }
        return new PlainFlavour();
    }

    public Sprinkles randomizeSprinkles() {
        Random random = new Random();
        int sprinkles = random.nextInt(3);
        switch (sprinkles) {
            case 0:
                return new ChocoSprinkles();
            case 1:
                return new RainbowSprinkles();
            case 2:
                return new CoconutSprinkles();
            case 3:
                return new MatchaSprinkles();

        }
        return null;
    }

    public Filling randomizeFilling() {
        Random random = new Random();
        int filling = random.nextInt(5);
        switch (filling) {
            case 0:
                return new FruitFilling();
            case 1:
                return new Ganache();
            case 2:
                return new Curds();
            case 3:
                return new CaramelFilling();
            case 4:
                return new ButterCream();
            case 5:
                return new VanillaFilling();
        }
        return new ButterCream();
    }

    public Sauce randomizeSauce() {
        Random random = new Random();
        int sauces = random.nextInt(4);
        switch (sauces) {
            case 0:
                return new LemonSauce();
            case 1:
                return new RaspberrySauce();
            case 2:
                return new ChocoSauce();
            case 3:
                return new CaramelSauce();
            case 4:
                return new WalnutSauce();
        }
        return null;
    }

    public Drizzle randomizeDrizzle() {
        Random random = new Random();
        int drizzle = random.nextInt(3);
        switch (drizzle) {
            case 0:
                return new ChocoDrizlle();
            case 1:
                return new FruitDrizzle();
            case 2:
                return new CaramelDrizzle();
            case 3:
                return new ColoredDrizzle("Random");
        }
        return null;
    }

    public Decorations randomizeDecorations() {
        Random random = new Random();
        int decorations = random.nextInt(3);
        switch (decorations) {
            case 0:
                return new Brittle();
            case 1:
                return new WholeFruits();
            case 2:
                return new Flowers(1);
            case 3:
                return new GumDrop();
        }
        return null;
    }
}

class TieredCake extends Cake {

    TieredCake(int tier) {
        super(tier);
        try {
            if (tier >= 0 || tier <= 5) {
                throw new InvalidTier();
            }
        } catch (InvalidTier e) {
            System.out.println(e.getMessage());
        }
    }

    public double calculatePrice() {
        int price = Tier * 20;
        for (CakeAddons add : CaAddons) {
            price += add.getCost();
        }
        return price;
    }

    public boolean canAdd(CakeAddons addon) {
        return true;
    }

    public String getCakeName() {
        return "Tiered Cake";
    }

}

class CheeseCake extends Cake {

    CheeseCake(int tier) {
        super(tier);
        tier = 1;
    }

    public double calculatePrice() {
        int price = 35;
        for (CakeAddons add : CaAddons) {
            price += add.getCost();
        }
        return price;
    }

    public boolean canAdd(CakeAddons addon) {
        if (addon instanceof Flavour || addon instanceof Sprinkles || addon instanceof Filling) {
            return false;
        }
        return true;
    }

    public String getCakeName() {
        return "Cheesecake";
    }
}

class CupCake extends Cake {
    private int amount;

    CupCake(int tier, int amount) {
        super(tier);
        tier = 1;
        this.amount = amount;
        if (amount % 5 != 0) {
            amount = (amount / 5) * 5;
        }
    }

    public double calculatePrice() {
        int price = amount * 15;
        for (CakeAddons add : CaAddons) {
            price += add.getCost();
        }
        return price;
    }

    public boolean canAdd(CakeAddons addon) {
        if (addon instanceof Sauce || addon instanceof Drizzle || addon instanceof Writing) {
            return false;
        }
        return true;
    }

    public String getCakeName() {
        return "Cupcake";
    }

}

class Brownie extends Cake {

    Brownie(int tier) {
        super(tier);
        tier = 1;
        addAddons(new ChocoFlavour());
    }

    public double calculatePrice() {
        int price = 45;
        for (CakeAddons add : CaAddons) {
            price += add.getCost();
        }
        return price;
    }

    public boolean canAdd(CakeAddons addon) {
        if (addon instanceof Filling || addon instanceof Sauce || addon instanceof Drizzle) {
            return false;
        }
        return true;
    }

    public String getCakeName() {
        return "Brownie";
    }

}

class WeddingCake extends Cake {

    WeddingCake(int tier) {
        super(tier);
        try {
            if (tier <= 0 || tier >= 6)
                throw new InvalidTier();
        } catch (InvalidTier e) {
            System.out.println(e.getMessage());
        }
    }

    public double calculatePrice() {
        int price = Tier * 50;
        for (CakeAddons add : CaAddons) {
            price += add.getCost();
        }
        return price;
    }

    public boolean canAdd(CakeAddons addon) {

        return true;
    }

    public String getCakeName() {
        return "Wedding Cake";
    }
}