import java.util.Random;

public class Snake extends Obstacle {
    public Snake() {
        super("Yılan", 4, randomDamage(), 12, 0);
    }

    private static int randomDamage() {
        Random random = new Random();
        return random.nextInt(3, 7);
    }

//    private static int snakeAward() {
//        Random random = new Random();
//        int randomAward = random.nextInt(101);
//        if (randomAward <= 25) {
//            return 10;
//        } else if (randomAward <= 50) {
//            return 5;
//        } else {
//            return 1;
//        }
//    }
}
