import by.epam.lamashka.reader.Reader;
import by.epam.lamashka.reader.TextFileReader;
import org.junit.Assert;
import org.junit.Test;

public class ReaderTest {
    @Test
    public void textReaderTest(){
        String readText;
    String sourceText =
        "\tBye бандерлоги. Bye бандерлоги. Bye бандерлоги. Bye бандерлоги.\r\n"
            + "\tIt has survived - not only (five) centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the \"Динамо\" (Рига) with the release of Letraset sheets.toString() containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker Faclon9 including versions of Lorem Ipsum! Bye бандерлоги.\r\n"
            + "\tIt is a long a!=b established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Ipsum is that it has a more-or-less normal distribution ob.toString(a?b:c), as opposed to using (Content here), content here's, making it look like readable English?\r\n"
            + "\tIt ЛОЖЬ is a established fact that a reader will be of a page when looking at its layout...\r\n";
        Reader textReader = new TextFileReader();
        readText = textReader.read("SourceText.txt");
        Assert.assertEquals(sourceText, readText);
    }
}
