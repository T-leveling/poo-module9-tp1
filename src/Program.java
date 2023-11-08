import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Program {

	public static void main(String[] args) throws IOException {
		var random = new Random();
		var scanner = new Scanner(System.in);

		String[] dico = Dictionnaire.InitializedData();
		String wordCharacters = Dictionnaire.tirerMotAleatoire(dico, random);
		List<Character> characters = new ArrayList<>();
		for (char c : wordCharacters.toCharArray()) {
			characters.add(c);
		}
		Collections.shuffle(characters);
		StringBuilder shuffledWord = new StringBuilder();
		for (char c : characters) {
			shuffledWord.append(c);
		}

		boolean correct;

		var essai = 0;
		do {
			System.out.println("Voila le tirage :" + shuffledWord);
			System.out.println("Entrez une proposition");

			var proposition = scanner.nextLine();
			correct = Triage.bonneslettres(proposition, shuffledWord.toString());
			if (correct && Triage.isIdentique(wordCharacters.toString(), proposition)) {
				System.out.println("GG");
				return;
			} else {
				System.out.println("Echec n" + ++essai);
			}
		} while (essai < 5);
		System.out.println("Game Over");
		System.out.println("le mot était : "+ wordCharacters);

	}

}
