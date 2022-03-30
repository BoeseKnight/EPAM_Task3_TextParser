package by.epam.lamashka;

import by.epam.lamashka.entity.TextComponent;
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
    text = textReader.read("requirement.txt");
    logger.info(text);

    Parser textParser = new TextParser();
    TextComponent textComposite = textParser.parse(text);
  }
}
