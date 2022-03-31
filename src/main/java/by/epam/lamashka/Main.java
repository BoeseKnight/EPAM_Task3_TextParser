package by.epam.lamashka;

import by.epam.lamashka.entity.TextComponent;
import by.epam.lamashka.functional.ParagraphSort;
import by.epam.lamashka.functional.TextOperation;
import by.epam.lamashka.parser.Parser;
import by.epam.lamashka.parser.TextParser;
import by.epam.lamashka.reader.Reader;
import by.epam.lamashka.reader.TextFileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
  private static final Logger logger = LogManager.getLogger(Main.class);

  public static void main(String[] args) {
    String text;
    Reader textReader = new TextFileReader();
    text = textReader.read("SourceText.txt");
    logger.info("SOURCE TEXT");
    System.out.println(text);
    Parser textParser = new TextParser();
    TextComponent textComposite = textParser.parse(text);
    logger.info("RECOVERED TEXT:");
    textComposite.printContent();
    System.out.println();
    TextOperation paragraphSort = new ParagraphSort();
    paragraphSort.run(textComposite);
    logger.info("PARAGRAPH SORT");
    textComposite.printContent();

  }
}
