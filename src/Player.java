import java.util.Scanner;

public class Player {

    private int damage;
    private int health;
    private int money;
    private String characterName;
    private String playerName;
    Scanner input = new Scanner(System.in);

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public void selectCharacter() {
        Samurai samurai = new Samurai();
        Archer archer = new Archer();
        Knight knight = new Knight();

        GameCharacter[] characterList = {new Samurai(), new Archer(), new Knight()};
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Karakterler");

        for (GameCharacter gameCharacter : characterList) {
            System.out.println("ID: " + gameCharacter.getCharacterID() +
                    "\tKarakter: " + gameCharacter.getCharacterName() +
                    "\t\tHasar: " + gameCharacter.getDamage() +
                    "\t\tSağlık: " + gameCharacter.getHealth() +
                    "\t\tPara: " + gameCharacter.getMoney());
        }

        System.out.println("---------------------------------------------------------------------------");
        System.out.print("Lütfen seçmek istediğiniz karakterin ID numarasını giriniz: ");
        int selectCharacter = input.nextInt();

        switch (selectCharacter) {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }
        System.out.println("Karakter: " + this.getCharacterName() +
                "\t\tHasar: " + this.getDamage() +
                "\t\tSağlık: " + this.getHealth() +
                "\t\tPara: " + this.getMoney());
    }

    public void initPlayer(GameCharacter gameCharacter) {
        this.setDamage(gameCharacter.getDamage());
        this.setHealth(gameCharacter.getHealth());
        this.setMoney(gameCharacter.getMoney());
        this.setCharacterName(gameCharacter.getCharacterName());
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
