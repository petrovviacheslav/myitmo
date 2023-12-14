package human;

public enum Condition {
    SLEEPING("спит"),
    AWAKE("бодрствует");

    private String description;

    Condition(String description){
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
}
