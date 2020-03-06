import element.Element;

public class ArenaDrawer {
    GUI gui;

    public ArenaDrawer(GUI gui) {
        this.gui = gui;
    }

    void draw(Element element){
        this.gui.drawCharacter(element.getPosition(), element.getPattern(), element.getColor());
    }
}
