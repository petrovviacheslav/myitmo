package room;

public enum InterectingObject {
    BUTTONS("разные кнопки"),
    THERMOSTAT("дверцы термостатов"),
    FRIDGE("дверцы холодильников"),
    CLOSETS("дверцы стенных шкафов");
    private final String description;

    InterectingObject(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
