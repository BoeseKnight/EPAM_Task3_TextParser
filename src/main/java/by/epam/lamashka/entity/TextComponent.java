package by.epam.lamashka.entity;

import java.util.List;

public interface TextComponent {
  void printContent();

  List<TextComponent> getTextComponentList();

  CompositeType getCompositeType();

  String getContent();
}
