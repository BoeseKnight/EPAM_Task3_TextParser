package by.epam.lamashka.functional;

import by.epam.lamashka.entity.TextComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VowelsConsonantsCount implements TextOperation {
  private static final Logger logger = LogManager.getLogger(VowelsConsonantsCount.class);

  @Override
  public TextComponent run(TextComponent text) {
    long vowelsLettersCount =
        text.getTextComponentList().stream()
            .flatMap(paragraph -> paragraph.getTextComponentList().stream())
            .flatMap(sentence -> sentence.getTextComponentList().stream())
            .flatMap(word -> word.getTextComponentList().stream())
            .filter(letter -> letter.getContent().matches("[aeiou]|[уеэоаыи]"))
            .count();
    logger.info(vowelsLettersCount);

    long consonantsLettersCount =
        text.getTextComponentList().stream()
            .flatMap(paragraph -> paragraph.getTextComponentList().stream())
            .flatMap(sentence -> sentence.getTextComponentList().stream())
            .flatMap(word -> word.getTextComponentList().stream())
            .filter(
                letter ->
                    letter
                        .getContent()
                        .matches(
                            "[bcdfghjklmnpqrstvwxyz]|[йцкнгшщзхфвпрлджчсмтб]")) // let's consider that 'y' is consonant.
            .count();
    logger.info(consonantsLettersCount);
    return text;
  }
}
