package element;

import element.position.Position;

public class Element {
    private String pattern;
    private String color;
    private Position position;

    public Element(int x, int y, String pattern, String color) {
        this.pattern = pattern;
        this.color = color;
        this.position = new Position(x, y);
    }

    public Element(Position position, String pattern, String color) {
        this.pattern = pattern;
        this.color = color;
        this.position = position;
    }

    public String getPattern() {
        return pattern;
    }

    public String getColor() {
        return color;
    }

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
