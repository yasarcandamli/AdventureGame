public class Weapon {
    private String weaponName;
    private int weaponID;
    private int weaponDamage;
    private int weaponPrice;

    public Weapon(String weaponName, int weaponID, int weaponDamage, int weaponPrice) {
        this.weaponName = weaponName;
        this.weaponID = weaponID;
        this.weaponDamage = weaponDamage;
        this.weaponPrice = weaponPrice;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public static Weapon[] weapons() {
        Weapon[] weaponList = new Weapon[3];
        weaponList[0] = new Weapon("Tabanca", 1, 2, 5);
        weaponList[1] = new Weapon("Kılıç", 2, 3, 35);
        weaponList[2] = new Weapon("Tüfek", 3, 7, 45);
        return weaponList;
    }

    public static Weapon getWeaponObjectByID(int weaponID) {
        for (Weapon weapon : Weapon.weapons()) {
            if (weapon.getWeaponID() == weaponID) {
                return weapon;
            }
        }
        return null;
    }

    public int getWeaponID() {
        return weaponID;
    }

    public void setWeaponID(int weaponID) {
        this.weaponID = weaponID;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }

    public int getWeaponPrice() {
        return weaponPrice;
    }

    public void setWeaponPrice(int weaponPrice) {
        this.weaponPrice = weaponPrice;
    }
}
