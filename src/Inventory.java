import java.util.ArrayList;

public class Inventory {
    private Weapon weapon;
    private Armor armor;
    private ArrayList<String> award;

    public Inventory() {
        this.weapon = new Weapon("Yumruk", -1, 0, 0);
        this.armor = new Armor("Paçavra", -1, 0, 0);
        this.award = new ArrayList<>();
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public ArrayList<String> getAward() {
        return award;
    }

    public void setAward(ArrayList<String> award) {
        this.award = award;
    }

    public String addAward(String award) {
        this.award.add(award);
        return award;
    }
}
