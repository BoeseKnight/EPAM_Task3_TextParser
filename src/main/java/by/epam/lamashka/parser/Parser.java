package by.epam.lamashka.parser;

import by.epam.lamashka.entity.TextComponent;

public interface Parser {
  TextComponent parse(String text);
}
