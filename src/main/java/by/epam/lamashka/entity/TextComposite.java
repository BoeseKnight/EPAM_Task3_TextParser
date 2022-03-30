package by.epam.lamashka.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {
    private final static Logger logger = LogManager.getLogger(TextComposite.class);
    private List<TextComponent> textComponentList;
    private CompositeType compositeType;
    {
        textComponentList = new ArrayList<>();
    }

    public TextComposite(CompositeType compositeType) {
        this.compositeType = compositeType;
    }

    public void add(TextComponent textComponent){
        textComponentList.add(textComponent);
    }

    @Override
    public void printContent() {
        textComponentList.forEach((component)->logger.info(component));
    }
}
