public class Shop {
    public void buyEnhancement(Player player, Enhancements enhancement) {
        try {
            if (player.balance > enhancement.price) {
                player.enhancements.add(enhancement);
            } else {
                throw new InvalidBalance();
            }
        } catch (InvalidBalance e) {
            System.out.println(e.getMessage(player, enhancement.price));
        }
    }
}

abstract class Enhancements {

    protected int price;
    protected String grade; // Legendary, Great, Standart

    Enhancements(int price, String grade) {
        this.price = price;
        this.grade = grade;
    }

}

class MachineEnhancements extends Enhancements {

    MachineEnhancements(int price, String grade) {
        super(price, grade);
    }

}
