public class StringReplacer implements StringTransformer {
    private Character toReplace;
    private Character replaceBy;

    public StringReplacer(Character toReplace, Character replaceBy) {
        this.toReplace = toReplace;
        this.replaceBy = replaceBy;
    }

    public void execute(StringDrink drink) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < drink.getText().length(); i++) {
            char elem = drink.getText().charAt(i);
            if (elem == this.toReplace) stringBuffer.append(this.replaceBy);
            else stringBuffer.append(elem);
        }
        drink.setText(stringBuffer.toString());
    }

    public void undo(StringDrink drink) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < drink.getText().length(); i++) {
            char elem = drink.getText().charAt(i);
            if (elem == this.replaceBy) stringBuffer.append(this.toReplace);
            else stringBuffer.append(elem);
        }
        drink.setText(stringBuffer.toString());
    }
}
