class Oven {

    private static int totalCakeBaked;

    public void addAddonToCake(Cake cake, CakeAddons add) {

        if (cake instanceof TieredCake) {
            try {
                if (((TieredCake) cake).canAdd(add) == true) {
                    cake.addAddons(add);
                    System.out.println(add.getName() + " has been added");
                } else {
                    throw new InvalidAddon();
                }
            } catch (InvalidAddon e) {
                System.out.println(e.getMessage(add, cake));
            }

        } else if (cake instanceof CheeseCake) {
            try {
                if (((CheeseCake) cake).canAdd(add) == true) {
                    cake.addAddons(add);
                    System.out.println(add.getName() + " has been added");
                } else {
                    throw new InvalidAddon();
                }
            } catch (InvalidAddon e) {
                System.out.println(e.getMessage(add, cake));
            }

        } else if (cake instanceof CupCake) {
            try {
                if (((CupCake) cake).canAdd(add) == true) {
                    cake.addAddons(add);
                    System.out.println(add.getName() + " has been added");
                } else {
                    throw new InvalidAddon();
                }
            } catch (InvalidAddon e) {
                System.out.println(e.getMessage(add, cake));
            }

        } else if (cake instanceof Brownie) {
            try {
                if (((Brownie) cake).canAdd(add) == true) {
                    cake.addAddons(add);
                    System.out.println(add.getName() + " has been added");
                } else {
                    throw new InvalidAddon();
                }
            } catch (InvalidAddon e) {
                System.out.println(e.getMessage(add, cake));
            }

        } else if (cake instanceof WeddingCake) {
            try {
                if (((WeddingCake) cake).canAdd(add) == true) {
                    cake.addAddons(add);
                    System.out.println(add.getName() + " has been added");
                } else {
                    throw new InvalidAddon();
                }
            } catch (InvalidAddon e) {
                System.out.println(e.getMessage(add, cake));
            }

        }

    }

    public void printCake(Cake cake) {
        String order = "Order: ";
        order += cake.getCakeName();

        for (CakeAddons add : cake.CaAddons) {
            order += " + " + add.getName();
        }

        order += "\n Total price: " + cake.calculatePrice();
        System.out.println(order);
        totalCakeBaked++;
    }

    public void totalCake() {
        System.out.println("Baked " + totalCakeBaked + " cakes");
    }
}