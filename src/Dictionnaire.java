import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Dictionnaire {


    static String tirerMotAleatoire(String[] dico, Random random) {
        var indexRandom = random.nextInt(dico.length);
        return dico[indexRandom];
    }

    static String[] InitializedData() throws IOException {
        var fis = new FileInputStream("./dictionnaire.txt");
        var scanner = new Scanner(fis);
        var count = 0;

        while (scanner.hasNext()) {
            scanner.nextLine();
            count++;
        }

        scanner.close();
        fis.close();

        var dico = new String[count];
        count = 0;

        fis = new FileInputStream("./dictionnaire.txt");
        scanner = new Scanner(fis);
        while (scanner.hasNext()) {
            dico[count++] = scanner.nextLine();
        }
        fis.close();
        scanner.close();
        return dico;
    }
}