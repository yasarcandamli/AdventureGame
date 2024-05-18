public abstract class GameCharacter {
    private int characterID;
    private String characterName;
    private int damage;
    private int health;
    private int money;

    public GameCharacter(int characterID, String characterName, int damage, int health, int money) {
        this.characterID = characterID;
        this.characterName = characterName;
        this.damage = damage;
        this.health = health;
        this.money = money;
    }

    public int getCharacterID() {
        return characterID;
    }

    public void setCharacterID(int characterID) {
        this.characterID = characterID;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
