package by.epam.lamashka.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Letter implements TextComponent {
  private static final Logger logger = LogManager.getLogger(Letter.class);
  private Character letter;

  public Letter(Character letter) {
    this.letter = letter;
  }

  public String getContent() {
    return String.valueOf(letter);
  }

  @Override
  public void printContent() {
    System.out.print(letter);
  }

  @Override
  public List<TextComponent> getTextComponentList() {
    throw new UnsupportedOperationException("Letter is a leaf, it doesn't have other components.");
  }

  @Override
  public CompositeType getCompositeType() {
    return CompositeType.LETTER;
  }
}
