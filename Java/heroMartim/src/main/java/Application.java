import java.io.IOException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        while(true) {
            try {
                Game game = new Game();
                game.run();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Enter R to restart: ");
            Scanner scanner = new Scanner(System.in);
            if(!scanner.next().equals("R")) {
                break;
            }
        }
    }
}