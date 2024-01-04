package InanimateCreatures;

import Interfaces.Writeable;

public class Book implements Writeable {
    private String text;

    public Book() {
        this.text = "";
    }

    @Override
    public void writeDown(String text) {
        this.text += text;
        System.out.println(String.format("В книгу записали: \"%s\"", this.text));
    }
}
