package room;

public enum HeadPad {
    FIST("кулак"),
    PILLOW("подушку");
    private final String description;

    HeadPad(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
