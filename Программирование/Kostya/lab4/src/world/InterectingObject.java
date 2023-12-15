package world;

public enum InterectingObject {
    BUTTONS("кнопки"),
    THERMOSTAT("термостаты"),
    FRIDGE("холодильники"),
    CLOSETS("шкафы");
    private final String description;

    InterectingObject(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
