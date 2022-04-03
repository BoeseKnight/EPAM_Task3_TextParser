import by.epam.lamashka.entity.TextComponent;
import by.epam.lamashka.functional.*;
import by.epam.lamashka.parser.Parser;
import by.epam.lamashka.parser.TextParser;
import by.epam.lamashka.reader.Reader;
import by.epam.lamashka.reader.TextFileReader;
import org.junit.Assert;
import org.junit.Test;

public class TextOperationsTest {
  @Test
  public void paragraphSortTest() {
    String text;
    Reader textReader = new TextFileReader();
    text = textReader.read("SourceText.txt");
    Parser textParser = new TextParser();
    TextComponent textComposite = textParser.parse(text);

    String expectedParagraphOrder =
        "\tIt ЛОЖЬ is a established fact that a reader will be of a page when looking at its layout...\r\n"
            + "\tIt is a long a!=b established fact that a reader will be distracted by the readable content of a page when looking at its layout.The point of using Ipsum is that it has a more-or-less normal distribution ob.toString(a?b:c), as opposed to using (Content here), content here's, making it look like readable English?\r\n"
            + "\tIt has survived - not only (five) centuries, but also the leap into electronic typesetting, remaining essentially unchanged.It was popularised in the \"Динамо\" (Рига) with the release of Letraset sheets.toString() containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker Faclon9 including versions of Lorem Ipsum!Bye бандерлоги.\r\n"
            + "\tBye бандерлоги.Bye бандерлоги.Bye бандерлоги.Bye бандерлоги.\r\n";
    TextOperation paragraphSort = new ParagraphSort();
    paragraphSort.run(textComposite);
    Assert.assertEquals(expectedParagraphOrder, textComposite.getContent());
  }

  @Test
  public void vowelsConsonantsCountTest() {
    String text;
    Reader textReader = new TextFileReader();
    text = textReader.read("SourceText.txt");
    Parser textParser = new TextParser();
    TextComponent textComposite = textParser.parse(text);

    String expectedVowelsConsonantsNumber = "253 392";
    TextOperation vowelsConsonantsCount = new VowelsConsonantsCount();
    String vowelsConsonantsNumber = vowelsConsonantsCount.run(textComposite).getContent();
    Assert.assertEquals(expectedVowelsConsonantsNumber, vowelsConsonantsNumber);
  }

  @Test
  public void sentencesDeleteTest() {
    String text;
    Reader textReader = new TextFileReader();
    text = textReader.read("SourceText.txt");
    Parser textParser = new TextParser();
    TextComponent textComposite = textParser.parse(text);

    String expectedText =
        "\tIt has survived - not only (five) centuries, but also the leap into electronic typesetting, remaining essentially unchanged.It was popularised in the \"Динамо\" (Рига) with the release of Letraset sheets.toString() containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker Faclon9 including versions of Lorem Ipsum!\tIt is a long a!=b established fact that a reader will be distracted by the readable content of a page when looking at its layout.The point of using Ipsum is that it has a more-or-less normal distribution ob.toString(a?b:c), as opposed to using (Content here), content here's, making it look like readable English?\r\n"
            + "\tIt ЛОЖЬ is a established fact that a reader will be of a page when looking at its layout...\r\n";
    TextOperation sentencesDelete = new SentencesDelete();
    TextComponent textWithDeleted = sentencesDelete.run(textComposite);
    Assert.assertEquals(expectedText, textWithDeleted.getContent());
  }

  @Test
  public void longestWordFindTest() {
    String text;
    Reader textReader = new TextFileReader();
    text = textReader.read("SourceText.txt");
    Parser textParser = new TextParser();
    TextComponent textComposite = textParser.parse(text);

    String expectedWord =
            "ob.toString(a?b:c), ";
    TextOperation longestWordFind = new LongestWordFind();
    TextComponent longestWord = longestWordFind.run(textComposite);
    Assert.assertEquals(expectedWord, longestWord.getContent());
  }
}
