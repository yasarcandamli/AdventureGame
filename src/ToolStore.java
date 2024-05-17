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
                break;
            case 3:
                System.out.println("Bir daha bekleriz!");

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
    }

    public void buyWeapon() {
        System.out.print("Bir silah seçiniz: ");
        int selectWeaponID = input.nextInt();
        while (selectWeaponID < 1 || selectWeaponID > Weapon.weapons().length) {
            System.out.print("Geçersiz bir değer girdiniz, tekrar giriniz: ");
            selectWeaponID = input.nextInt();
        }

        Weapon selectedWeapon = Weapon.getWeaponObjectByID(selectWeaponID);

        if (selectedWeapon != null) {
            if (selectedWeapon.getWeaponPrice() > this.getPlayer().getMoney()) {
                System.out.println("Yeterli paranız bulunmamaktadır!");
            } else {
                //Satın almanın gerçekleştiği alan
                System.out.println(selectedWeapon.getWeaponName() + " silahını satın aldnız!");
                int balance = this.getPlayer().getMoney() - selectedWeapon.getWeaponPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("Kalan paranız: " + this.getPlayer().getMoney());
                System.out.println("Önceki silahınız: " + this.getPlayer().getInventory().getWeapon().getWeaponName());
                this.getPlayer().getInventory().setWeapon(selectedWeapon);
                System.out.println("Yeni silahınız: " + this.getPlayer().getInventory().getWeapon().getWeaponName());

            }
        }
    }

    public void printArmor() {
        System.out.println("---------- Zırhlar ----------");
    }

    public void menu() {

    }

    public void buy() {

    }
}
