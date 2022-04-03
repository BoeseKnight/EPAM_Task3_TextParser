package by.epam.lamashka.parser;

import by.epam.lamashka.entity.CompositeType;
import by.epam.lamashka.entity.Letter;
import by.epam.lamashka.entity.TextComponent;
import by.epam.lamashka.entity.TextComposite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WordParser implements Parser {
  private static final Logger logger = LogManager.getLogger(WordParser.class);

  @Override
  public TextComponent parse(String word) {
    //    logger.debug("IN WORD PARSER");
    TextComposite wordComposite = new TextComposite(CompositeType.WORD);
    TextComponent letter;
    for (int i = 0; i < word.length(); i++) {
      //      logger.debug(word.charAt(i));
      letter = new Letter(word.charAt(i));
      wordComposite.add(letter);
    }
    return wordComposite;
  }
}
