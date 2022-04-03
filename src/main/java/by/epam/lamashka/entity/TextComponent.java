package by.epam.lamashka.entity;

import java.util.List;

public interface TextComponent {

  List<TextComponent> getTextComponentList();

  CompositeType getCompositeType();

  String getContent();
}
