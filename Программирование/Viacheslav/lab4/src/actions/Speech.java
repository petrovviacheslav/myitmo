package actions;
public enum Speech {
    Tell(" говорил", "у"),
    Ask(" спросил", "а"),
    Answer(" ответил", "у");
    private final String type;
    private final String rusCase;

    Speech(String type, String rusCase) {
        this.type = type;
        this.rusCase = rusCase;
    }

    public String getType() {
        return type;
    }
    public String getCase() {
        return rusCase;
    }
}