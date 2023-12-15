package world;

public enum Place {
    PLASTIC("пластмассе"),
    SHELF("На полках"),
    COMPARTMENT_BOTTOM("растянулся на дне отсека");

    private final String description;

    Place(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

