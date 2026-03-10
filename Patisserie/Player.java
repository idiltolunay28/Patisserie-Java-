import java.util.ArrayList;

class Player {
    public int level;
    protected BufferedImage player_png;
    protected int balance;
    protected ArrayList<Enhancements> enhancements;

    Player() {
        this.level = 1;
        this.balance = 0;
        this.enhancements = new ArrayList<>();
    }

    public int getBalance() {
        return balance;
    }

}
