public class Obstacle {
    private String obstacleName;
    private int obstacleID;
    private int obstacleDamage;
    private int obstacleHealth;
    private int obstacleAward;
    private int originalObstacleHealth;

    public Obstacle(String obstacleName, int obstacleID, int obstacleDamage, int obstacleHealth, int obstacleAward) {
        this.obstacleName = obstacleName;
        this.obstacleID = obstacleID;
        this.obstacleDamage = obstacleDamage;
        this.obstacleHealth = obstacleHealth;
        this.originalObstacleHealth = obstacleHealth;
        this.obstacleAward = obstacleAward;
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
        if (obstacleHealth < 0) {
            obstacleHealth = 0;
        }
        this.obstacleHealth = obstacleHealth;
    }

    public int getObstacleAward() {
        return obstacleAward;
    }

    public void setObstacleAward(int obstacleAward) {
        this.obstacleAward = obstacleAward;
    }

    public int getOriginalObstacleHealth() {
        return originalObstacleHealth;
    }

    public void setOriginalObstacleHealth(int originalObstacleHealth) {
        this.originalObstacleHealth = originalObstacleHealth;
    }
}
