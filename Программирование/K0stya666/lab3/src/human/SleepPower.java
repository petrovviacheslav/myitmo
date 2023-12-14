package human;

public enum SleepPower {
    STRONG("крепко"),
    notSTRONG("не крепко"),
    ;

    private final String description;

    SleepPower(String description){
        this.description = description;
    }

    public String getDescription() {return description;
    }
}
