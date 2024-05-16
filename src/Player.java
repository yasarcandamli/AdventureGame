public class Player {

    private int damage;
    private int health;
    private int money;
    private String playerName;
    private String characterName;

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public void selectCharacter() {
        Samurai samurai = new Samurai();
        Archer archer = new Archer();
        Knight knight = new Knight();

        GameCharacter[] characterList = {new Samurai(), new Archer(), new Knight()};
        System.out.println("Karakterler");
        for (GameCharacter gameCharacter : characterList) {
            System.out.println("Karakter: \t" + gameCharacter.getCharacterName() +
                    "\t\tHasar: " + gameCharacter.getDamage() +
                    "\t\tSağlık: " + gameCharacter.getHealth() +
                    "\t\tPara: " + gameCharacter.getMoney());
        }
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

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }
}
