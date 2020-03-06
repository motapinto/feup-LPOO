import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        Game game = null;
        try {
            game = new Game(50, 20, 4, 5, 3);
            game.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
