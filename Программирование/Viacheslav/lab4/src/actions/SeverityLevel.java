package actions;
public enum SeverityLevel {
    NotSeriously(""),
    Seriously(" серьёзно");

    private final String level;

    SeverityLevel(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }
}