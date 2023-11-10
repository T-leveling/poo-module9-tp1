import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tirage {
    private String word;
    private Random random = new Random();

    public Tirage(String word) {
        this.word = word;
    }

    public List<Character> Shuffle() {
        var letters = word.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            var temp = letters[i];
            var index = random.nextInt(letters.length);
            letters[i] = letters[index];
            letters[index] = temp;
        }

        var value = new ArrayList<Character>();
        for (var l : letters) {
            value.add(l);
        }
        return value;
    }

    public static boolean bonneslettres(String letters, String mot) {
        var value = new ArrayList<Character>();
        for (var l : mot.toCharArray()) {
            value.add(l);
        }
        return bonneslettres(letters, value);
    }

    public static boolean bonneslettres(String proposition, List<Character> shuffledLetters) {
        var letters = new ArrayList<>(shuffledLetters);
        for (char c : proposition.toCharArray()) {
            var found = false;
            for (int i = 0; i < letters.size(); i++) {
                if (letters.get(i).charValue() == c) {
                    letters.set(i, '0');
                    found = true;
                    break;
                }
            }
            if (!found)
                return false;
        }
        return true;
    }

    public boolean isIdentique(String proposition) {
        return proposition.equalsIgnoreCase(word);
    }

    public String getMot() {
        return word;
    }

}
