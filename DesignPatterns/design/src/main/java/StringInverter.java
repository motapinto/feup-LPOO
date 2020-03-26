public class StringInverter implements StringTransformer {

    public void execute(StringDrink drink) {
        StringBuffer stringBuffer = new StringBuffer(drink.getText());
        stringBuffer = stringBuffer.reverse();
        drink.setText(stringBuffer.toString());
    }

    public void undo(StringDrink drink) {
        this.execute(drink);
    }
}