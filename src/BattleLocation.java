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
        int obstacleNumber = this.randomObstacleNumber();
        System.out.println("Şu an buradasınız: " + this.getLocationName());
        System.out.println("Dikkali ol! Burada " + obstacleNumber + " tane " + this.getObstacle().getObstacleName() + " yaşamakta!");
        System.out.print("<S>avaş veya <K>>aç: ");
        String selectCase = input.nextLine();
        selectCase = selectCase.toUpperCase();

        if (selectCase.equals("S")) {
            System.out.println("Savaş işlemleri olacak");
            //Savaşma işlemi
        }
        return true;
    }

    public int randomObstacleNumber() {
        Random random = new Random();
        return random.nextInt(this.getMaxObstacle()) + 1;
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
