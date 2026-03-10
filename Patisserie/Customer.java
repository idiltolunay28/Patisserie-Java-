import java.util.ArrayList;
import java.util.Random;

class Customer {
    private String name;
    @SuppressWarnings("unused")
    private ArrayList<Orderable> order;

    Customer(String name, int orderCount) {
        this.name = name;
        this.order = new ArrayList<>();
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getName() {
        return name;
    }

    public void randomizeOrder(int orderCount) {
        Random random = new Random();

        // Item Count
        @SuppressWarnings("unused")
        int item = 1 + random.nextInt(1); // maybe

        // Cake tier Randomization
        int randomtier = 1 + random.nextInt(6);

        int order = random.nextInt(2);
        int n = 0;
        while (n < orderCount) {
            switch (order) {
                case 0: // Coffe
                    randomizeCoffe();
                    break;
                case 1: // Cake
                    randomizeCake(randomtier);
                    break;
                case 2:
                    break;
            }
            n++;
        }
    }

    public Coffe randomizeCoffe() {
        Random random = new Random();
        int coffe = random.nextInt(3);
        int iced = random.nextInt(1);
        switch (coffe) {
            case 0:
                switch (iced) {
                    case 0:
                        return new Espresso(false);
                    case 1:
                        return new Espresso(true);
                }
            case 1:
                switch (iced) {
                    case 0:
                        return new Latte(false);
                    case 1:
                        return new Latte(true);
                }
            case 2:
                switch (iced) {
                    case 0:
                        return new Americano(false);
                    case 1:
                        return new Americano(true);
                }
            case 3:
                switch (iced) {
                    case 0:
                        return new Macchiato(false);
                    case 1:
                        return new Macchiato(true);
                }
        }
        return new Espresso(false);
    }

    public Cake randomizeCake(int caketier) {
        Random random = new Random();
        int cake = random.nextInt(4);
        switch (cake) {
            case 0:
                return new TieredCake(caketier);
            case 1:
                return new CheeseCake(caketier);
            case 2:
                return new CupCake(caketier, 20);
            case 3:
                return new Brownie(caketier);
        }
        return new TieredCake(caketier);
    }

    public FruitJuices randomizeJuice() {
        Random random = new Random();
        int juice = random.nextInt(3);
        int iced = random.nextInt(1);
        switch (juice) {
            case 0:
                switch (iced) {
                    case 0:
                        return new Lemonade(false);
                    case 1:
                        return new Lemonade(true);
                }
            case 1:
                switch (iced) {
                    case 0:
                        return new OrangeJuice(false);
                    case 1:
                        return new OrangeJuice(true);
                }
            case 2:
                switch (iced) {
                    case 0:
                        return new AppleJuice(false);
                    case 1:
                        return new AppleJuice(true);
                }
        }
        return new Lemonade(false);
    }

}
