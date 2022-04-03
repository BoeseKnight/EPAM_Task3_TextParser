package by.epam.lamashka.functional;

import by.epam.lamashka.entity.CompositeType;
import by.epam.lamashka.entity.TextComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.Comparator;

public class ParagraphSort implements TextOperation {
  private static final Logger logger = LogManager.getLogger(ParagraphSort.class);

  @Override
  public TextComponent run(TextComponent text) {
    Comparator<TextComponent> comparator =
        Comparator.comparing(
            component ->
                component.getCompositeType().equals(CompositeType.PARAGRAPH)
                    ? component.getTextComponentList().stream()
                        .filter(
                            textComponent ->
                                textComponent.getCompositeType() == CompositeType.SENTENCE)
                        .count()
                    : 0);
    Collections.sort(text.getTextComponentList(), comparator);
    return text;
  }
}
