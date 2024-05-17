public class ToolStore extends NormalLocation {
    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Mağazaya Hoşgeldiniz!");
        System.out.println("1-Silahlar");
        System.out.println("2-Zırhlar");
        System.out.println("3-Çıkış Yap");
        System.out.print("Seçiminiz: ");
        int selectCase = input.nextInt();
        while (selectCase < 1 || selectCase > 3){
            System.out.print("Geçersiz bir değer girdiniz, tekrar giriniz: ");
            selectCase = input.nextInt();
        }
        switch (selectCase){
            case 1:
                printWeapon();
                break;
            case 2:
                printArmor();
                break;
            case 3:
                System.out.println("Bir daha bekleriz!");

        }
        return true;
    }

    public void printWeapon(){
        System.out.println("---------- Silahlar ----------");
        System.out.println();
        for (Weapon weapon : Weapon.weapons()){
            System.out.println(weapon.getWeaponName() + "\tPara: " + weapon.getWeaponPrice() + "\tHasar: " + weapon.getWeaponDamage());
        }
    }

    public void printArmor(){
        System.out.println("---------- Zırhlar ----------");
    }

    public void menu() {

    }

    public void buy() {

    }
}
