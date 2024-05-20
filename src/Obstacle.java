public class Obstacle {
    private String obstacleName;
    private int obstacleID;
    private int obstacleDamage;
    private int obstacleHealth;

    public Obstacle(String obstacleName, int obstacleID, int obstacleDamage, int obstacleHealth) {
        this.obstacleName = obstacleName;
        this.obstacleID = obstacleID;
        this.obstacleDamage = obstacleDamage;
        this.obstacleHealth = obstacleHealth;
    }

    public String getObstacleName() {
        return obstacleName;
    }

    public void setObstacleName(String obstacleName) {
        this.obstacleName = obstacleName;
    }

    public int getObstacleID() {
        return obstacleID;
    }

    public void setObstacleID(int obstacleID) {
        this.obstacleID = obstacleID;
    }

    public int getObstacleDamage() {
        return obstacleDamage;
    }

    public void setObstacleDamage(int obstacleDamage) {
        this.obstacleDamage = obstacleDamage;
    }

    public int getObstacleHealth() {
        return obstacleHealth;
    }

    public void setObstacleHealth(int obstacleHealth) {
        this.obstacleHealth = obstacleHealth;
    }
}
