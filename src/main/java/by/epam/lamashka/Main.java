package by.epam.lamashka;

import by.epam.lamashka.entity.TextComponent;
import by.epam.lamashka.functional.LongestWordFind;
import by.epam.lamashka.functional.ParagraphSort;
import by.epam.lamashka.functional.SentencesDelete;
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
    TextOperation longestWordFind = new LongestWordFind();
    TextOperation deleteSentences = new SentencesDelete();

    paragraphSort.run(textComposite);
    logger.info("PARAGRAPH SORT");
    textComposite.printContent();
    System.out.println();

    TextComponent maxWord = longestWordFind.run(textComposite);
    logger.info("LONGEST WORD");
    maxWord.printContent();
    System.out.println();
    textComposite = deleteSentences.run(textComposite);
    logger.info("DELETED SENTENCES");
    textComposite.printContent();
    paragraphSort.run(textComposite);
    logger.info("PARAGRAPH SORT");
    textComposite.printContent();
    System.out.println();
  }
}
