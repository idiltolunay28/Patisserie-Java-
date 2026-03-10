class FruitSqueezer {

    private static int totalJuiceSqueezed;

    public void addIcetoJuice(FruitJuices juice, JuiceAddons addon) {
        if (juice.getIced()) {
            juice.addAddons(new Ice());
        }
    }

    public void printJuice(FruitJuices juice) {
        String order = "";

        if (juice.getIced()) {
            order += " Iced";
        }

        order += juice.getJuiceName();

        for (JuiceAddons add : juice.JuAddons) {
            order += " + " + add.getName();
        }

        order += "\n Total price: " + juice.calculatePrice();
        System.out.println(order);
        totalJuiceSqueezed++;

    }

    public int totalJuice() {
        return totalJuiceSqueezed;
    }

}
