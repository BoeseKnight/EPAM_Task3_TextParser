package by.epam.lamashka.functional;

import by.epam.lamashka.entity.TextComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// Найти в тексте все одинаковые слова без учета регистра и посчитать их
// количество.
public class EqualWordsFind implements TextOperation {
  private static final Logger logger = LogManager.getLogger(EqualWordsFind.class);

  @Override
  public TextComponent run(TextComponent text) {
    Map<String, Integer> repeatedWords = new HashMap<>();
    List<TextComponent> words =
        text.getTextComponentList().stream()
            .flatMap(paragraph -> paragraph.getTextComponentList().stream())
            .flatMap(sentence -> sentence.getTextComponentList().stream())
            .collect(Collectors.toList());

    List<String> stringWords =
        words.stream().map(TextComponent::getContent).collect(Collectors.toList());

    stringWords.replaceAll(String::trim);

    IntStream.range(0, stringWords.size())
        .forEachOrdered(
            i ->
                stringWords.set(
                    i, stringWords.get(i).replaceAll("\\p{Punct}", "").toLowerCase(Locale.ROOT)));
//    logger.debug(stringWords);
    int count;
    for (String word : stringWords) {
      count = Collections.frequency(stringWords, word);
      if (count > 1) {
        repeatedWords.put(word, count);
      }
    }
    logger.info("REPEATED WORDS AND THEIR COUNT");
    logger.info(repeatedWords);
    return text;
  }
}
