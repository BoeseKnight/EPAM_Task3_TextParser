package by.epam.lamashka.parser;

import by.epam.lamashka.entity.CompositeType;
import by.epam.lamashka.entity.Letter;
import by.epam.lamashka.entity.TextComponent;
import by.epam.lamashka.entity.TextComposite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextParser implements Parser {
  private static final Logger logger = LogManager.getLogger(TextParser.class);

  @Override
  public TextComponent parse(String text) {
    logger.debug("IN TEXT PARSER");
    TextComposite textComposite = new TextComposite();
    TextComponent paragraphComposite;
    Parser paragraphParser = new ParagraphParser();
    String[] paragraphs = text.split(CompositeType.PARAGRAPH.getRegularExpression());
    for (String paragraph : paragraphs) {
      //      logger.debug(paragraph);
      paragraphComposite = paragraphParser.parse(paragraph);
      textComposite.add(paragraphComposite);
//      textComposite.add(new Letter('\n'));
//      textComposite.add(new Letter('\t'));
    }
    return textComposite;
  }
}
