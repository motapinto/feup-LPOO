import element.Element;
import element.position.Position;

public class Fixed extends Element {
    public Fixed(int x, int y, String pattern, String color) {
        super(x, y, pattern, color);
    }

    public Fixed(Position position, String pattern, String color) {
        super(position, pattern, color);
    }
}
