package by.epam.lamashka.functional;

import by.epam.lamashka.entity.TextComponent;

import java.util.Comparator;

public class LongestWordFind implements TextOperation {
  @Override
  public TextComponent run(TextComponent text) {
    TextComponent maxWord =
        text.getTextComponentList().stream()
            .flatMap(paragraph -> paragraph.getTextComponentList().stream())
            .flatMap(sentence -> sentence.getTextComponentList().stream())
            .max(Comparator.comparing(word -> word.getTextComponentList().size()))
            .get();
    return maxWord;
  }
}
