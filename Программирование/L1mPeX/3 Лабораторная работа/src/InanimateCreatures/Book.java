package InanimateCreatures;

import Interfaces.Writeable;

public class Book implements Writeable {
    private String text;

    public Book() {
        this.text = "";
    }

    public void addText(String text) {
        this.text += text;
        Writeable.beWrittenDown(text);
    }
}
