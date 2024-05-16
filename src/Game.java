import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);

    public void startGame() {
        System.out.println("Macera Oyununa Hoşgeldiniz!");
        System.out.print("Lütfen İsim Giriniz: ");
        String playerName = input.nextLine();

        Player player = new Player(playerName);
        System.out.println("Sayın " + player.getPlayerName() + " bu karanlık ve sisli adaya hoşgeldiniz! Burada yaşanan her şey gerçek!");
        System.out.println("Lütfen bir karakter seçiniz: ");
        player.selectCharacter();
    }
}
