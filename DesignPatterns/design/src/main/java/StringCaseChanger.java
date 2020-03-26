public class StringCaseChanger implements StringTransformer{

    public void execute(StringDrink drink) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < drink.getText().length(); i++) {
            char elem = drink.getText().charAt(i);
            if (Character.isLowerCase(elem)) elem -= 32;
            else if (Character.isUpperCase(elem)) elem += 32;
            stringBuffer.append(elem);
        }
        drink.setText(stringBuffer.toString());
    }

    public void undo(StringDrink drink) {
        this.execute(drink);
    }
}