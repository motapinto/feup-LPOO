import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.*;
import com.googlecode.lanterna.screen.*;
import com.googlecode.lanterna.terminal.*;

import java.io.IOException;

public class Game {
    private Screen screen;
    private Arena arena;
    private TextGraphics graphics;

    public Game() throws IOException {
        try {
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null);   // we don't need a cursor
            screen.startScreen();             // screens must be started
            screen.doResizeIfNecessary();     // resize screen if necessary

            arena = new Arena(79, 20);

            draw();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void draw() throws IOException {
        screen.clear();
        arena.draw(screen.newTextGraphics());
        screen.refresh();
    }

    public void run() throws IOException {
        while(true) {
            draw();
            if(!processKey(screen.readInput())) {
                break;
            }
        }
    }

    private boolean processKey(KeyStroke key){
        //closes the screen
        if(key.getKeyType().equals(KeyType.Character) && key.getCharacter() == 'q') {
            try {
                screen.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return arena.processKey(key);
    }
}

//Copy the code that initializes the terminal and screen to the default constructor of this new class. This time make the screen variable a class field.