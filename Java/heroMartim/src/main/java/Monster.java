import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Monster extends Element {
    public Monster(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#F84D4D"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(this.getPosition().getX(), this.getPosition().getY()), "T");
    }

    public Position move() {
        Random rand = new Random();
        switch (rand.nextInt(4)) {
            case 0:
                return new Position(this.getPosition().getX() + 1, this.getPosition().getY());
            case 1:
                return new Position(this.getPosition().getX() - 1, this.getPosition().getY());
            case 2:
                return new Position(this.getPosition().getX(), this.getPosition().getY() + 1);
            case 3:
                return new Position(this.getPosition().getX(), this.getPosition().getY() - 1);
        }
        return new Position(this.getPosition().getX(), this.getPosition().getY());
    }
}
