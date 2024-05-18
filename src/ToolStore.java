public class ToolStore extends NormalLocation {
    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Mağazaya Hoşgeldiniz!");
        boolean showMenu = true;
        while (showMenu) {
            System.out.println("1-Silahlar");
            System.out.println("2-Zırhlar");
            System.out.println("3-Çıkış Yap");
            System.out.print("Seçiminiz: ");
            int selectCase = input.nextInt();
            while (selectCase < 1 || selectCase > 3) {
                System.out.print("Geçersiz bir değer girdiniz, tekrar giriniz: ");
                selectCase = input.nextInt();
            }
            switch (selectCase) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Bir daha bekleriz!");
                    showMenu = false;
                    break;
            }
        }
        return true;
    }

    public void printWeapon() {
        System.out.println("---------- Silahlar ----------");
        for (Weapon weapon : Weapon.weapons()) {
            System.out.println(weapon.getWeaponID() + " - " + weapon.getWeaponName() +
                    "\tPara: " + weapon.getWeaponPrice() +
                    "\tHasar: " + weapon.getWeaponDamage());
        }
        System.out.println("0 - Çıkış yap");
    }

    public void buyWeapon() {
        System.out.print("Bir silah seçiniz: ");
        int selectWeaponID = input.nextInt();
        while (selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length) {
            System.out.print("Geçersiz bir değer girdiniz, tekrar giriniz: ");
            selectWeaponID = input.nextInt();
        }

        if (selectWeaponID != 0) {
            Weapon selectedWeapon = Weapon.getWeaponObjectByID(selectWeaponID);

            if (selectedWeapon != null) {
                if (selectedWeapon.getWeaponPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli paranız bulunmamaktadır!");
                } else {
                    //Satın almanın gerçekleştiği alan
                    System.out.println(selectedWeapon.getWeaponName() + " silahını satın aldnız!");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getWeaponPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan bakiyeniz: " + this.getPlayer().getMoney());
                    System.out.println("Önceki silahınız: " + this.getPlayer().getInventory().getWeapon().getWeaponName());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("Yeni silahınız: " + this.getPlayer().getInventory().getWeapon().getWeaponName());
                }
            }
        }
    }

    public void printArmor() {
        System.out.println("---------- Zırhlar ----------");
        for (Armor armor : Armor.armors()) {
            System.out.println(armor.getArmorID() + " - " + armor.getArmorName() +
                    "\tPara: " + armor.getArmorPrice() +
                    "\tZırh: " + armor.getArmorBlock());
        }
        System.out.println("0 - Çıkış yap");
    }

    public void buyArmor() {
        System.out.print("Bir zırh seçiniz: ");
        int selectAromorID = input.nextInt();
        while (selectAromorID < 0 || selectAromorID > Armor.armors().length) {
            System.out.print("Geçersiz bir değer girdiniz, tekrar giriniz: ");
            selectAromorID = input.nextInt();
        }

        if (selectAromorID != 0) {
            Armor selectedArmor = Armor.getArmorObjectByID(selectAromorID);

            if (selectedArmor != null) {
                if (selectedArmor.getArmorPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli paranız bulunmamaktadır!");
                } else {
                    //Satın almanın gerçekleştiği alan
                    System.out.println(selectedArmor.getArmorName() + " zırhını satın aldnız!");
                    this.getPlayer().setMoney(this.getPlayer().getMoney() - selectedArmor.getArmorPrice());
                    System.out.println("Kalan bakiyeniz: " + this.getPlayer().getMoney());
                    System.out.println("Önceki zırhınız: " + this.getPlayer().getInventory().getArmor().getArmorName());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("Yeni zırhınız: " + this.getPlayer().getInventory().getArmor().getArmorName());

                }
            }
        }
    }

    public void menu() {

    }

    public void buy() {

    }
}
