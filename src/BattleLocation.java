import java.util.Random;

public abstract class BattleLocation extends Location {
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public BattleLocation(Player player, String locationName, Obstacle obstacle, String award, int maxObstacle) {
        super(player, locationName);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    @Override
    public boolean onLocation() {
        if (getPlayer().getInventory().getAward().contains(getAward())) {
            System.out.println("Buraya daha önce girdiniz ve ödülünüzü aldınız!");
            return true;
        }
        int obstacleNumber = this.randomObstacleNumber();
        System.out.println("Şu an buradasınız: " + this.getLocationName());
        System.out.println("Dikkali ol! Burada " + obstacleNumber + " tane " + this.getObstacle().getObstacleName() + " yaşamakta!");
        System.out.print("<S>avaş veya <K>>aç: ");
        String selectCase = input.nextLine().toUpperCase();

        if (selectCase.equals("S") && combat(obstacleNumber)) {
            System.out.println(this.getLocationName() + " tüm düşmanları yendiniz!");
            return true;
        }

        if (this.getPlayer().getHealth() <= 0) {
            System.out.println("Öldünüz!");
            return false;
        }

        return true;
    }

    public int randomObstacleNumber() {
        Random random = new Random();
        return random.nextInt(this.getMaxObstacle()) + 1;
    }

    public boolean combat(int obstacleNumber) {
        Random random = new Random();

        for (int i = 1; i <= obstacleNumber; i++) {
            int firstAttack = random.nextInt(2);
            this.getObstacle().setObstacleHealth(this.getObstacle().getOriginalObstacleHealth());
            playerStats();
            obstacleStats(i);

            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getObstacleHealth() > 0) {
                System.out.print("<V>ur veya <K>aç: ");
                String selectCombat = input.nextLine().toUpperCase();

                if (selectCombat.equals("V")) {
                    if (firstAttack == 0) {
                        System.out.println("Siz vurdunuz!");
                        this.getObstacle().setObstacleHealth(this.getObstacle().getObstacleHealth() - this.getPlayer().getTotalDamage());
                        afterHit();
                        if (this.getObstacle().getObstacleHealth() > 0) {
                            System.out.println();
                            System.out.println("Canavar size vurdu!");
                            int obstacleDamage = this.getObstacle().getObstacleDamage() - this.getPlayer().getInventory().getArmor().getArmorBlock();
                            if (obstacleDamage < 0) {
                                obstacleDamage = 0;
                            }
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                            afterHit();
                        }
                    } else {
                        System.out.println("Canavar size vurdu!");
                        int obstacleDamage = this.getObstacle().getObstacleDamage() - this.getPlayer().getInventory().getArmor().getArmorBlock();
                        if (obstacleDamage < 0) {
                            obstacleDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                        afterHit();
                        if (this.getPlayer().getHealth() > 0) {
                            System.out.println();
                            System.out.println("Siz vurdunuz!");
                            this.getObstacle().setObstacleHealth(this.getObstacle().getObstacleHealth() - this.getPlayer().getTotalDamage());
                            afterHit();
                        }
                    }

                } else {
                    return false;
                }
            }

            if (this.getObstacle().getObstacleHealth() < this.getPlayer().getHealth()) {
                System.out.println("Düşmanı Yendiniz!");
                System.out.println(this.getObstacle().getObstacleAward() + " para kazandınız!");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getObstacleAward());
                System.out.println("Güncel paranız: " + this.getPlayer().getMoney());
            } else {
                return false;
            }
        }
        if (this.getPlayer().getHealth() > 0) {
            getPlayer().getInventory().addAward(getAward());
            System.out.println("Bölgeye Özel Ödül Kazandınız: " + getAward());
        }
        return false;
    }

    public void afterHit() {
        System.out.println("Canınız: " + this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getObstacleName() + " Canı: " + this.getObstacle().getObstacleHealth());
        System.out.println();
    }

    public void playerStats() {
        System.out.println("Oyuncu Değerleri");
        System.out.println("-----------------------------------");
        System.out.println("Sağlık: " + this.getPlayer().getHealth());
        System.out.println("Hasar: " + this.getPlayer().getDamage());
        System.out.println("Para: " + this.getPlayer().getMoney());
        System.out.println("Silah: " + this.getPlayer().getInventory().getWeapon().getWeaponName());
        System.out.println("Zırh: " + this.getPlayer().getInventory().getArmor().getArmorName());
        System.out.println("Bloklama: " + this.getPlayer().getInventory().getArmor().getArmorBlock());
        System.out.println();
    }

    public void obstacleStats(int i) {
        System.out.println(i + ". " + this.getObstacle().getObstacleName() + " Değerleri");
        System.out.println("-----------------------------------");
        System.out.println("Sağlık: " + this.getObstacle().getObstacleHealth());
        System.out.println("Hasar: " + this.getObstacle().getObstacleDamage());
        System.out.println("Ödül: " + this.getObstacle().getObstacleAward());
        System.out.println();
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
