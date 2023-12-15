package room;

public enum Place {
    PLASTIC("пластмассе"),
    SHELF("На полках"),
    COMPARTMENT_BOTTOM("на дне отсека");

    private final String description;

    Place(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

