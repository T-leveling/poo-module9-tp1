import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Dictionnaire {
    private List<String> mots = new ArrayList<String>();
    private Map<Integer, List<String>> map = new HashMap<>();

    private Random random = new Random();

    public Dictionnaire(String path) throws IOException {
        var fis = new FileInputStream(path);
        var scanner = new Scanner(fis);

        while (scanner.hasNext()) {
            var mot = scanner.nextLine();
            mots.add(mot);

            var motSize = mot.length();
            if (!map.containsKey(motSize))
                map.put(motSize, new ArrayList<>());
            map.get(motSize).add(mot);
        }
        scanner.close();
        fis.close();
    }

    public List<String> getMots() {
        return mots;
    }

    public String tirerMotAleatoire() {
        var indexRandom = random.nextInt(mots.size());
        return mots.get(indexRandom);
    }

    public List<String> wordsBySizeForTirage(int i, Tirage tirage) {
        var motsValides = new ArrayList<String>();
        for (String mot : map.get(i)) {
            if (Tirage.bonneslettres(mot,tirage.getMot())) {
                motsValides.add(mot);
            }
        }
        return motsValides;
    }
}
