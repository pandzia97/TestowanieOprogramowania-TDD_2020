import org.junit.Test;
import java.io.IOException;
import java.nio.file.Paths;
import static org.junit.Assert.*;

public class tests {

    @Test
    public void fileNull() throws IOException {
        //given
        //slowo w pliku null
        //when
        int result = main.czytaniePliku("slowo", null);
        //then
        assertEquals(0, result);
    }
    @Test
    public void nonExistentWordInFile() throws IOException {
        //given
        //slowo, ktore nie jest zawarte w istniejacym pliku
        //when
        int result = main.czytaniePliku("strona", Paths.get("src", "test", "resources", "plik").toFile());
        //then
        assertEquals(0, result);
    }

    @Test
    public void wordNull() throws IOException {
        //given
        //null zamiast slowa w istniejacym pliku
        //when
        int result = main.czytaniePliku(null, Paths.get("src", "test", "resources", "plik").toFile());
        //then
        assertEquals(0,result);
    }

    @Test
    public void wordInTheWrongLocation() throws IOException {
        //given
        //jakies slowo i nieistniejacy plik w lokalizacji
        //when
        int result = main.czytaniePliku("slowo", Paths.get("src", "test", "resources", "hehe").toFile());
        //then
        assertEquals(0, result);
    }

    @Test
    public void emptyWord() throws IOException {
        //given
        //pusta spacja w istniejacym pliku
        //when
        int result = main.czytaniePliku(" ", Paths.get("src","test", "resources", "plik").toAbsolutePath().toFile());
        //then
        assertEquals(0, result);
    }

    @Test
    public void wordContainedInAnExistingFile() throws IOException {
        //given
        //slowo zawarte w istniejacym pliku
        //when
        int result = main.czytaniePliku("lorem", Paths.get("src", "test", "resources", "plik").toAbsolutePath().toFile());
        //then
        assertEquals(3, result);
    }
}