import java.io.*;
import java.util.*;

public class Program {

    public static void main(String[] args) throws IOException {
        Dictionnaire dico = null;
        boolean correct;
        var essai = 0;

        try (var scanner = new Scanner(System.in)) {
            try {
                dico = Dictionnaire.getInstance();
            } catch (Exception e) {
                System.err.println("le dictionnaire n'est pas au chemin fourni");
            }
            var tirage = new Tirage(dico.tirerMotAleatoire());
            var shuffledLetters = tirage.Shuffle();

            do {
                System.out.println("Voila le tirage :" + shuffledLetters);
                System.out.println("Entrez une proposition");
                var proposition = scanner.nextLine();

                correct = Tirage.bonneslettres(proposition, shuffledLetters);
                if (correct && tirage.isIdentique(proposition)) {
                    System.out.println("GG");
                    return;
                } else {
                    System.out.println("Echec n" + ++essai);
                }
            } while (essai < 5);
            System.out.println("Game Over");
            System.out.println("le mot était : " + tirage.getMot());

            for (int i = tirage.getMot().length(); i > 0; i--) {
                var list = dico.wordsBySizeForTirage(i, tirage);
                if (!list.isEmpty()) {
                    System.out.println("Mots de " + i + " caractères ");
                    for (String s : list) {
                        System.out.println(s);
                    }
                }
            }

        }
    }
}
