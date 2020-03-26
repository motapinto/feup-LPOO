import java.util.ArrayList;
import java.util.List;

public class SmartStrategy implements OrderingStrategy {
    List<StringRecipe> recipes = new ArrayList<>();
    List<StringDrink> drinks = new ArrayList<>();
    List<StringBar> bars = new ArrayList<>();

    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {
        if (bar.isHappyHour()) bar.order(drink, recipe);
        else {
            recipes.add(recipe);
            drinks.add(drink);
            bars.add(bar);
        }
    }

    @Override
    public void happyHourStarted(StringBar bar) {
        for (int i = 0; i < drinks.size(); i++) {
            if(bar == bars.get(i)) {
                bar.order(this.drinks.remove(i), this.recipes.remove(i));
                this.bars.remove(i);
                i--;
            }
        }

        recipes.clear();
    }

    @Override
    public void happyHourEnded(StringBar bar) {

    }
}
