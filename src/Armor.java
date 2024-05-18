public class Armor {
    private String armorName;
    private int armorID;
    private int armorBlock;
    private int armorPrice;

    public Armor(String armorName, int armorID, int armorBlock, int armorPrice) {
        this.armorName = armorName;
        this.armorID = armorID;
        this.armorBlock = armorBlock;
        this.armorPrice = armorPrice;
    }

    public static Armor[] armors() {
        Armor[] armorList = new Armor[3];
        armorList[0] = new Armor("Hafif", 1, 1, 15);
        armorList[1] = new Armor("Orta", 2, 3, 25);
        armorList[2] = new Armor("Ağır", 3, 5, 40);

        return armorList;
    }

    public static Armor getArmorObjectByID(int armorID) {
        for (Armor armor : Armor.armors()) {
            if (armor.getArmorID() == armorID) {
                return armor;
            }
        }
        return null;
    }

    public int getArmorID() {
        return armorID;
    }

    public void setArmorID(int armorID) {
        this.armorID = armorID;
    }

    public String getArmorName() {
        return armorName;
    }

    public void setArmorName(String armorName) {
        this.armorName = armorName;
    }

    public int getArmorBlock() {
        return armorBlock;
    }

    public void setArmorBlock(int armorBlock) {
        this.armorBlock = armorBlock;
    }

    public int getArmorPrice() {
        return armorPrice;
    }

    public void setArmorPrice(int armorPrice) {
        this.armorPrice = armorPrice;
    }
}
