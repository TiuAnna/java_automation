import java.util.ArrayList;

public class StringChanges {
    ArrayList<String> stringForReverse = new ArrayList<>();

    public void prep(String typeToDisplay) {
        stringForReverse.clear();
        for (int i = 0; i < typeToDisplay.length(); i++) {
            stringForReverse.add(String.valueOf(typeToDisplay.charAt(i)));
        }
    }

    public String reverse(String typeToDisplay) {
        for (int i = 0; i < stringForReverse.size() / 2; i++) {
            typeToDisplay = stringForReverse.get(i);
            stringForReverse.set(i, stringForReverse.get(stringForReverse.size() - i - 1));
            stringForReverse.set(stringForReverse.size() - i - 1, typeToDisplay);
        }
        return typeToDisplay;
    }


}
