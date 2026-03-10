class InvalidTier extends Exception {

    InvalidTier() {
        super();
    }

    public String getMessage() {
        return "Tier size is invalid. Tier should be between 1 and 5. Please try again";
    }
}

class InvalidAddon extends Exception {

    InvalidAddon() {
        super();
    }

    public String getMessage(CoffeAddons add, Coffe coffe) {
        return "[Warning]" + add.getName() + " can't be added to " + coffe.getCoffeName();
    }

    public String getMessage(CakeAddons add, Cake cake) {
        return "[Warning]" + add.getName() + " can't be added to " + cake.getCakeName();
    }

}

class InvalidBalance extends Exception {

    InvalidBalance() {
        super();
    }

    public String getMessage(Player player, int price) {
        return "[Warning] Balance is insufficient! Balance: " + player.balance + " Price: " + price;
    }

}