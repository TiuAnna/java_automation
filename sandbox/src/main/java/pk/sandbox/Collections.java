package pk.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {
    public static void main(String[] args) {
        String[] langs = {"Java", "Python", "C#", "PHP"};
//        Instead of usual (int i = 0....) the next expression is used to perform an action for each MASSIVE value
        for (String l : langs) {
            System.out.println("I want to study " + l);
        }
        ArrayList<String> languages = new ArrayList<>();
//     to set all necessary values to the list use
//        List<String> languages = Arrays.asList("Java", "python");
        languages.clear();
        for (int i = 0; i < langs.length; i++) {
            languages.add(langs[i]);
            System.out.println("I want to study " + languages.get(i));
        }
    }
}
