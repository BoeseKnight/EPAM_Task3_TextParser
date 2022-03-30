package by.epam.lamashka.parser;

import by.epam.lamashka.entity.CompositeType;
import by.epam.lamashka.entity.TextComponent;
import by.epam.lamashka.entity.TextComposite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ParagraphParser implements Parser {
  private static final Logger logger = LogManager.getLogger(ParagraphParser.class);

  @Override
  public TextComponent parse(String paragraph) {
    TextComposite paragraphComposite = new TextComposite(CompositeType.PARAGRAPH);
    TextComponent sentenceComposite;
    Parser sentenceParser=new SentenceParser();
    String[] sentences = paragraph.split(CompositeType.SENTENCE.getRegularExpression());
    for (String sentence : sentences) {
//      logger.debug(sentence);
      sentenceComposite=sentenceParser.parse(sentence);
      paragraphComposite.add(sentenceComposite);
    }
    return paragraphComposite;
  }
}
