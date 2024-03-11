import java.util.Random;

public class Snake extends Obstacle {

    private static Random random = new Random();

    Snake() {
        super("Yılan", random.nextInt(3) + 3, 12, 0, 5);
    }
}
