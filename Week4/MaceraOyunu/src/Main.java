import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        try {
            game.login();
        }catch(NoSuchElementException e) {}
    }

}
