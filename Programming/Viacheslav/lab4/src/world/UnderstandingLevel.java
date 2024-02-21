package world;
public enum UnderstandingLevel {
    All("всё-всё"),
    Nothing("ничего не");
    private final String level;

    UnderstandingLevel(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }
}