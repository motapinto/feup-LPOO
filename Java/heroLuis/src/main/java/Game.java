import element.Element;

import java.io.*;
import java.util.List;

public class Game {
    private final LanternaGUI gui;
    private ArenaDrawer drawer = null;
    private Arena arena = null;

    public Game(int width, int height, int lives, int maxCoins, int monsters) throws IOException {
        this.arena = new Arena(width, height, lives, maxCoins, monsters);
        this.gui = new LanternaGUI(width, height);
        this.drawer = new ArenaDrawer(this.gui);
    }

    public void run() throws IOException {
        Movement movement;
        do {
            this.draw();
            movement = this.gui.getMovement();

            if(movement == Movement.QUIT){
                this.gui.close();
                break;
            }

        } while (!this.arena.processMovement(movement));

        this.gui.close();
    }

    private void draw() throws IOException {
        List<Element> elements = this.arena.getElements();

        this.gui.clear();

        for(Element element : elements){
            this.drawer.draw(element);
        }

        this.gui.refresh();
    }

}
