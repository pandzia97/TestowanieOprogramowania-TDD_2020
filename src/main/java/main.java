import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class main {

    public static void main(String[] args) {
    }

    public static int czytaniePliku(String slowoLiczone, File plik) throws IOException {
        if (plik == null) {
            return 0;
        }

        if (!plik.exists()) {
            return 0;
        }
        int licznik = 0;
        List<String> lines = Files.readAllLines(plik.toPath());

        for (String s : lines) {
            s = s.replace(".", " ").replace(",", " ").replace(":", " ").replace(";", " ").replace("'", " ".replace("?", " ").replace("!", " "));

            String[] words = s.split(" ");
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(slowoLiczone)) {

                    licznik++;
                }
            }
        }
        return licznik;
    }
}