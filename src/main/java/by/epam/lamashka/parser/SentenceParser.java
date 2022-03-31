package by.epam.lamashka.parser;

import by.epam.lamashka.entity.CompositeType;
import by.epam.lamashka.entity.Letter;
import by.epam.lamashka.entity.TextComponent;
import by.epam.lamashka.entity.TextComposite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SentenceParser implements Parser {
  private static final Logger logger = LogManager.getLogger(SentenceParser.class);

  @Override
  public TextComponent parse(String sentence) {
    logger.debug("IN SENTENCE PARSER");
    TextComposite sentenceComposite = new TextComposite(CompositeType.SENTENCE);
    TextComponent wordComposite;
    Parser wordParser=new WordParser();
    String[] words = sentence.split(CompositeType.WORD.getRegularExpression());
    for (String word : words) {
//      logger.debug(word);
      wordComposite=wordParser.parse(word);
      sentenceComposite.add(wordComposite);
      sentenceComposite.add(new Letter(' '));
    }
    return sentenceComposite;
  }
}
