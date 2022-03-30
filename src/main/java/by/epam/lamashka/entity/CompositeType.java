package by.epam.lamashka.entity;

public enum CompositeType {
  SENTENCE("\\."),
  WORD(" "),
  PARAGRAPH("\r\n\t"),
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
