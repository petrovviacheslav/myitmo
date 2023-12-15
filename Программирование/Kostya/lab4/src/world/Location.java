package world;

public enum Location {
    ELEVATOR ("лифт"),
    CROOKED_CORRIDOR ("кривой коридорчик"),
    FOOD_COMPARTMENT ("пищевой отсек"),
    DOOR ("дверь"),
    NOWHERE(""),
    COMPARTMENT_BOTTOM("растянулся на дне отсека");

    private String description;
    Location (String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}
