package by.epam.lamashka.functional;

import by.epam.lamashka.entity.TextComponent;
import by.epam.lamashka.entity.TextComposite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

public class SentencesDelete implements TextOperation {
  private static final Logger logger = LogManager.getLogger(SentencesDelete.class);

  @Override
  public TextComponent run(TextComponent text) {

    List<TextComponent> listWithDeletedSentences =
        text.getTextComponentList().stream()
            .flatMap(paragraph -> paragraph.getTextComponentList().stream())
            .filter(sentence -> sentence.getTextComponentList().size() > 5)
            .collect(Collectors.toList());
    return new TextComposite(listWithDeletedSentences);
  }
}
