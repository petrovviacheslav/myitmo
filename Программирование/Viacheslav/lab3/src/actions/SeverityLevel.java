package actions;
public enum SeverityLevel {
    NotSeriously("серьёзно"),
    Seriously("");

    private final String url;

    SeverityLevel(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}