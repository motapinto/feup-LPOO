import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import element.position.Position;
import org.w3c.dom.Text;

import java.io.IOException;

public class LanternaGUI implements GUI {
    private final int width;
    private final int height;
    private Terminal terminal = null;
    private Screen screen = null;
    private TextGraphics graphics = null;

    public LanternaGUI(int width, int height) throws IOException {
        this.width = width;
        this.height = height;
        this.terminal = new DefaultTerminalFactory().createTerminal();
        this.screen = new TerminalScreen(terminal);

        this.screen.setCursorPosition(null);   // we don't need a cursor
        this.screen.startScreen();             // screens must be started
        this.screen.doResizeIfNecessary();     // resize screen if necessary
    }

    @Override
    public Movement getMovement() throws IOException {
        KeyStroke key = null;

        try {
            key = this.screen.readInput();
        } catch (IOException e) {
            e.printStackTrace();
            return Movement.QUIT;
        }

        switch (key.getKeyType()){
            case ArrowUp:
                return Movement.UP;
            case ArrowRight:
                return Movement.RIGHT;
            case ArrowDown:
                return Movement.DOWN;
            case ArrowLeft:
                return Movement.LEFT;
            case Character:
                if(key.getCharacter() == 'q')
                    return Movement.QUIT;
                return Movement.NONE;
            case EOF:
                return Movement.QUIT;
        }

        return Movement.NONE;
    }

    @Override
    public void clear() {
        this.screen.clear();
        this.graphics = this.screen.newTextGraphics();
        this.graphics.setBackgroundColor(TextColor.Factory.fromString("#111813"));
        this.graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(this.width, this.height), ' ');
    }

    @Override
    public void drawCharacter(Position position, String pattern, String color) {
        this.graphics.setForegroundColor(TextColor.Factory.fromString(color));
        this.graphics.putString(new TerminalPosition(position.getX(),position.getY()), pattern);
    }

    @Override
    public void refresh() throws IOException {
        this.screen.refresh();
    }

    @Override
    public void close() throws IOException {
        this.screen.close();
    }


}
