package room;

public enum Adjective {
    SOFT("мягкой"),
    HARD("жёсткой");
    private final String description;

    Adjective(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
