import java.util.ArrayList;
import java.util.List;

public class StringBar extends Bar {

    private boolean happyHour = false;

    @Override
    public boolean isHappyHour() { return this.happyHour; };

    @Override
    public void startHappyHour() {
        this.happyHour = true;
        this.notifyObservers();
    };

    @Override
    public void endHappyHour() {
        this.happyHour = false;
        this.notifyObservers();
    };

    public void order(StringDrink drink, StringRecipe recipe) {
        recipe.mix(drink);
    }
}