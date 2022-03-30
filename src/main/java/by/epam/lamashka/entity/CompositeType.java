package by.epam.lamashka.entity;

public enum CompositeType {
    SENTENCE(".|?|!|..."), WORD(" "), PARAGRAPH("\n");
    String regularExpression;

    CompositeType(String regularExpression) {
        this.regularExpression = regularExpression;
    }

    public String getRegularExpression() {
        return regularExpression;
    }
}
