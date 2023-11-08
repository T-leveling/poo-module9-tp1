import java.util.Random;

public class Triage {
    static boolean isIdentique(String word, String proposition) {
        return word.equals(proposition);
    }

    static boolean bonneslettres(String proposition, String shuffledLetters) {
        var letters = shuffledLetters;
        for (char c : proposition.toCharArray()) {
            var found = false;
            for (int i = 0; i < letters.length(); i++) {
                if (letters.charAt(i) == c) {
                    letters.replace(letters.charAt(i),'0');
                    found = true;
                    break;
                }
            }
            if (!found)
                return false;
        }
        return true;
    }

}