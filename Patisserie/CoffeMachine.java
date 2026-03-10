class CoffeMachine {

    private static int totalCoffeMade;

    public void addAddonToCoffe(Coffe coffe, CoffeAddons add) {

        if (coffe.getIced()) {
            coffe.addAddons(new Ice());
            System.out.println("Ice has been added");
        }
        if (coffe instanceof Espresso) {
            try {
                if (((Espresso) coffe).canAdd(add) == true) {
                    ((Espresso) coffe).addAddons(add);
                    System.out.println(add.getName() + " has been added");
                } else {
                    throw new InvalidAddon();
                }
            } catch (InvalidAddon e) {
                System.out.println(e.getMessage(add, coffe));
            }

        } else if (coffe instanceof Latte) {
            try {
                if (((Latte) coffe).canAdd(add) == true) {
                    ((Latte) coffe).addAddons(add);
                    System.out.println(add.getName() + " has been added");
                } else {
                    throw new InvalidAddon();
                }
            } catch (InvalidAddon e) {
                System.out.println(e.getMessage(add, coffe));
            }
        } else if (coffe instanceof Americano) {
            try {
                if (((Americano) coffe).canAdd(add) == true) {
                    ((Americano) coffe).addAddons(add);
                    System.out.println(add.getName() + " has been added");
                } else {
                    throw new InvalidAddon();
                }
            } catch (InvalidAddon e) {
                System.out.println(e.getMessage(add, coffe));
            }
        } else if (coffe instanceof Macchiato) {
            try {
                if (((Macchiato) coffe).canAdd(add) == true) {
                    ((Macchiato) coffe).addAddons(add);
                    System.out.println(add.getName() + " has been added");
                } else {
                    throw new InvalidAddon();
                }
            } catch (InvalidAddon e) {
                System.out.println(e.getMessage(add, coffe));
            }
        }
    }

    public void makeCoffe(Coffe coffe) {
        String order = "Order: ";
        if (coffe.getIced() == true) {
            order += "Iced ";
        }

        if (coffe instanceof Espresso) {
            order += "Espresso ";
            if (((Espresso) coffe).getHeat() == true) {
                order += "(Hot Cup) ";
            }
        } else {
            order += coffe.getCoffeName();
        }

        for (CoffeAddons add : coffe.CoAddons) {
            order += " + " + add.getName();
        }

        order += "\n Total price: " + coffe.calculatePrice();
        System.out.println(order);
        totalCoffeMade++;
    }

    public void heatEspressoCup(Coffe coffee) {
        if (coffee instanceof Espresso) {
            ((Espresso) coffee).heatCup();
            System.out.println("Cup's heated!");
        }
    }

    public void totalCoffe() {
        System.out.println("Made " + totalCoffeMade + " coffe!");
    }

}
