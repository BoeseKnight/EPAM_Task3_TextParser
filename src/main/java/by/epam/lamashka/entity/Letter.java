package by.epam.lamashka.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Letter implements TextComponent {
    private final static Logger logger = LogManager.getLogger(Letter.class);
    private Character letter;

    public Letter(Character letter) {
        this.letter = letter;
    }

    @Override
    public void printContent() {
        logger.info(letter);
    }
}
