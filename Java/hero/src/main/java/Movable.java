import element.Element;
import element.position.Position;

public class Movable extends Element {
    public Movable(int x, int y, String pattern, String color) {
        super(x, y, pattern, color);
    }

    public Movable(Position position, String pattern, String color) {
        super(position, pattern, color);
    }

    public Position move(Movement movement) {
        switch (movement){
            case UP:
                return new Position(this.getPosition().getX(), this.getPosition().getY() - 1);
            case DOWN:
                return new Position(this.getPosition().getX(), this.getPosition().getY() + 1);
            case LEFT:
                return new Position(this.getPosition().getX() - 1, this.getPosition().getY());
            case RIGHT:
                return new Position(this.getPosition().getX() + 1, this.getPosition().getY());
            default:
                return this.getPosition();
        }
    }
}
