
import java.util.ArrayList;

public class Coffe_Mac {
    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine();

        BaseCoffee espresso = new Espresso();
        machine.addAddonToCoffee(espresso, new DoubleShot());
        machine.addAddonToCoffee(espresso, new Milk());
        machine.heatEspressoCup(espresso);
        machine.makeCoffee(espresso);

        BaseCoffee latte = new Latte();
        machine.addAddonToCoffee(latte, new Milk());
        machine.addAddonToCoffee(latte, new VanillaSyrup());
        machine.makeCoffee(latte);

        CoffeeMachine anotherMachine = new CoffeeMachine();
        BaseCoffee americano = new Americano();
        anotherMachine.heatEspressoCup(americano);
        anotherMachine.makeCoffee(americano);

        CoffeeMachine.displayTotalCoffee();
    }
}

interface CoffeeAddon {

    double getCost();

    String getName();
}

class Milk implements CoffeeAddon {

    public double getCost() {
        return 5;
    }

    public String getName() {
        return "Milk";
    }
}

class Chocolate implements CoffeeAddon {
    public double getCost() {
        return 7;
    }

    public String getName() {
        return "Chocolate";
    }
}

class VanillaSyrup implements CoffeeAddon {
    public double getCost() {
        return 6;
    }

    public String getName() {
        return "VanillaSyrup";
    }
}

class DoubleShot implements CoffeeAddon {
    public double getCost() {
        return 10;
    }

    public String getName() {
        return "DoubleShot";
    }
}

abstract class BaseCoffee {

    protected ArrayList<CoffeeAddon> addons;

    public BaseCoffee() {
        this.addons = new ArrayList<>();
    }

    public void addAddon(CoffeeAddon addon) {
        addons.add(addon);

    }

    public String getAddons() {
        String coffeeaddons = "";
        int size = 0;
        for (CoffeeAddon addon : addons) {
            if (size != addons.size()) {
                coffeeaddons += " + ";
            }
            coffeeaddons += addon.getName();
            size++;
        }
        return coffeeaddons;
    }

    public abstract double calculatePrice();

}

class Espresso extends BaseCoffee {

    private boolean isHeated;

    public Espresso() {
        this.isHeated = false;
    }

    public boolean canAdd(CoffeeAddon addon) {
        if (addon instanceof Milk || addon instanceof VanillaSyrup) {
            return false;
        }
        return true;
    }

    public double calculatePrice() {
        int price = 40;
        for (CoffeeAddon addon : addons) {
            price += addon.getCost();
        }
        return price;
    }

    public void heatCup() {
        this.isHeated = true;
    }

    public boolean getHeat() {
        return isHeated;
    }

}

class Latte extends BaseCoffee {

    public boolean canAdd(CoffeeAddon addon) {
        if (addon instanceof DoubleShot) {
            return false;
        }
        return true;
    }

    public double calculatePrice() {
        int price = 50;
        for (CoffeeAddon addon : addons) {
            price += addon.getCost();
        }
        return price;
    }

}

class Americano extends BaseCoffee {

    public boolean canAdd(CoffeeAddon addon) {
        if (addon instanceof Chocolate || addon instanceof DoubleShot) {
            return false;
        }
        return true;
    }

    public double calculatePrice() {
        int price = 45;
        for (CoffeeAddon addon : addons) {
            price += addon.getCost();
        }
        return price;
    }

}

class CoffeeMachine {

    private static int toplamKahveUretimi;

    public void addAddonToCoffee(BaseCoffee coffee, CoffeeAddon adddon) {

        if (coffee instanceof Espresso) {
            if (((Espresso) coffee).canAdd(adddon) == true) // temp'e gerek olmadan yazma!! :)
                ((Espresso) coffee).addAddon(adddon);
            else
                System.out.println("[UYARI] Espresso tip kahveye " + adddon.getName() + " eklenemez");
        } else if (coffee instanceof Latte) {
            if (((Latte) coffee).canAdd(adddon) == true)
                ((Latte) coffee).addAddon(adddon);
            else
                System.out.println("[UYARI] Latte tip kahveye " + adddon.getName() + " eklenemez");
        } else {
            if (((Americano) coffee).canAdd(adddon) == true)
                ((Americano) coffee).addAddon(adddon);
            else
                System.out.println("[UYARI] Americana tip kahveye " + adddon.getName() + " eklenemez");
        }

    }

    public void makeCoffee(BaseCoffee coffee) {

        String siparis = "";
        if (coffee instanceof Espresso) {
            siparis += "Sipariş: Espresso ";
            if (((Espresso) coffee).getHeat() == true)
                siparis += "(Sıcak Fincan)";
            else
                siparis += "(Soğuk Fincan)";
        } else if (coffee instanceof Latte) {
            siparis += "Sipariş: Latte";
        } else {
            siparis += "Sipariş: Americano";
        }

        siparis += coffee.getAddons();
        System.out.println(siparis);
        System.out.println("Toplam fiyat: " + coffee.calculatePrice());
        System.out.println();
        toplamKahveUretimi++;
    }

    public void heatEspressoCup(BaseCoffee coffee) {

        if (coffee instanceof Espresso) {
            ((Espresso) coffee).heatCup();
            System.out.println("Espresso kahve fincanı ısıtıldı");
        } else
            System.out.println("[UYARI] Yalnızca Espresso kahve fincanları ısıtılabilir");

    }

    public static void displayTotalCoffee() {
        System.out.println("Tum kahve makineleri toplam " + toplamKahveUretimi + " kahve uretmiştir");
    }
}