package by.epam.lamashka.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {
  private static final Logger logger = LogManager.getLogger(TextComposite.class);
  private List<TextComponent> textComponentList;
  private CompositeType compositeType;

  {
    textComponentList = new ArrayList<>();
  }

  public TextComposite() {}

  public TextComposite(CompositeType compositeType) {
    this.compositeType = compositeType;
  }

  public TextComposite(List<TextComponent> textComponentList) {
    this.textComponentList = textComponentList;
  }

  public void add(TextComponent textComponent) {
    textComponentList.add(textComponent);
  }

  public void setTextComponentList(List<TextComponent> textComponentList) {
    this.textComponentList = textComponentList;
  }

  @Override
  public void printContent() {
    textComponentList.forEach(TextComponent::printContent);
  }

  @Override
  public List<TextComponent> getTextComponentList() {
    return textComponentList;
  }

  @Override
  public CompositeType getCompositeType() {
    return compositeType;
  }
}
