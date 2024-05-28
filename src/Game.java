import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);

    public void startGame() {
        System.out.println("Macera Oyununa Hoşgeldiniz!");
        System.out.print("Lütfen İsim Giriniz: ");
        String playerName = input.nextLine();

        Player player = new Player(playerName);
        System.out.println("Sayın " + player.getPlayerName() + " bu karanlık ve sisli adaya hoşgeldiniz! Burada yaşanan her şey gerçek!");
        player.selectCharacter();

        Location location = null;
        while (true) {
            player.printInfo();
            System.out.println();
            System.out.println("----- Bölgeler -----");
            System.out.println();
            System.out.println("1-Güvenli Ev --> Burası sizin için güvenli bir ev, düşman yoktur!");
            System.out.println("2-Eşya Dükkanı --> Silah veya zırh satın alabilirsiniz!");
            System.out.println("3-Mağara --> Ödül: yemek, dikkatli ol karşına vampir çıkabilir!");
            System.out.println("4-Orman --> Ödül: odun, dikkatli ol karşına zombi çıkabilir!");
            System.out.println("5-Nehir --> Ödül: su, dikkatli ol karşına ayı çıkabilir!");
            System.out.println("6-Maden --> Ödül: ganimet, dikkatli ol karşına yılan çıkabilir!");
            System.out.println("0-Çıkış Yap --> Oyunu sonlandır!");
            System.out.print("Lütfen gitmek istediğiniz bölgeyi seçiniz: ");
            int selectLocation = input.nextInt();

            switch (selectLocation) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                case 6:
                    location = new Mine(player);
                    break;
                default:
                    System.out.println("Lütfen geçerli bir bölge giriniz!");
            }

            if (location == null) {
                System.out.println("Bu karanlık ve sisli adadan çabuk vazgeçtin!");
                break;
            }

            if (!location.onLocation()) {
                System.out.println("GAME OVER!");
                break;
            }
        }
    }
}
