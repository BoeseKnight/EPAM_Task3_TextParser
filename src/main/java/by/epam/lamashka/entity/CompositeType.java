package by.epam.lamashka.entity;

public enum CompositeType {
  SENTENCE("(?<!\\w\\.\\w.)(?<![A-Z][a-z]\\.)(?<=\\.|\\?|!)[\\p{Zs}|\\n]"),
  WORD("(?<=\\s)"),
  LEXEME(" "),
  PARAGRAPH("(?<=\\n)"),
  LETTER(),
  TEXT();

  String regularExpression;

  CompositeType() {}

  CompositeType(String regularExpression) {
    this.regularExpression = regularExpression;
  }

  public String getRegularExpression() {
    return regularExpression;
  }
}
