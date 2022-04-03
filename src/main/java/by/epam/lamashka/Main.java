package by.epam.lamashka;

import by.epam.lamashka.entity.TextComponent;
import by.epam.lamashka.functional.*;
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
    logger.info(text);

    Parser textParser = new TextParser();

    TextComponent textComposite = textParser.parse(text);
    TextComponent textCompositeWithDeletedSentences;

    logger.info("RECOVERED TEXT:");
    logger.info(textComposite.getContent());
    System.out.println();

    TextOperation paragraphSort = new ParagraphSort();
    TextOperation longestWordFind = new LongestWordFind();
    TextOperation deleteSentences = new SentencesDelete();
    TextOperation equalWordsFind = new EqualWordsFind();
    TextOperation vowelsConsonantsCount = new VowelsConsonantsCount();

    logger.info("PARAGRAPH SORT");
    paragraphSort.run(textComposite);
    logger.info(textComposite.getContent());
    System.out.println();

    logger.info("LONGEST WORD FIND");
    TextComponent maxWord = longestWordFind.run(textComposite);
    logger.info(maxWord.getContent());
    System.out.println();

    logger.info("TEXT WITH DELETED SENTENCES");
    textCompositeWithDeletedSentences = deleteSentences.run(textComposite);
    logger.info(textCompositeWithDeletedSentences.getContent());
    System.out.println();

    logger.info("REPEATED WORDS AND THEIR COUNT");
    equalWordsFind.run(textComposite);
    System.out.println();

    logger.info("NUMBER OF VOWELS AND CONSONANTS IN TEXT");
    vowelsConsonantsCount.run(textComposite);
    System.out.println();
  }
}
