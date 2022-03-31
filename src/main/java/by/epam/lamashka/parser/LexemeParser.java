package by.epam.lamashka.parser;

import by.epam.lamashka.entity.CompositeType;
import by.epam.lamashka.entity.TextComponent;
import by.epam.lamashka.entity.TextComposite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LexemeParser implements Parser{
    private static final Logger logger = LogManager.getLogger(LexemeParser.class);
    @Override
    public TextComponent parse(String lexeme) {
//        logger.debug("IN LEXEME PARSER");
        TextComposite lexemeComposite = new TextComposite(CompositeType.PARAGRAPH);
        TextComponent wordComposite;
        Parser sentenceParser=new SentenceParser();
        String[] words = lexeme.split(CompositeType.WORD.getRegularExpression());
        for (String word : words) {
//      logger.debug(sentence);
            wordComposite=sentenceParser.parse(word);
            lexemeComposite.add(wordComposite);
        }
        return lexemeComposite;
    }
}
