package by.epam.lamashka.functional;

import by.epam.lamashka.entity.TextComponent;
import by.epam.lamashka.entity.TextComposite;

import java.util.List;
import java.util.stream.Collectors;

public class SentencesDelete implements TextOperation {
  @Override
  public TextComponent run(TextComponent text) {
    List<TextComponent> listWithDeletedSentences =
        text.getTextComponentList().stream()
            .flatMap(paragraph -> paragraph.getTextComponentList().stream())
            .filter(sentence -> sentence.getTextComponentList().size() > 5)
            .collect(Collectors.toList());
    TextComponent textComposite = new TextComposite(listWithDeletedSentences);
    return textComposite;
  }
}
