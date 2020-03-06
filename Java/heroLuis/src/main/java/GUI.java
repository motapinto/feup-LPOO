import element.position.Position;

import java.io.IOException;

public interface GUI {
    Movement getMovement() throws IOException;
    void clear();
    void drawCharacter(Position position, String pattern, String color);
    void refresh() throws IOException;
    void close() throws IOException;
}
