package human;

import world.*;

public abstract class Person {
    private String rocketKnowledge;
    private String name;
    private Condition condition;
    private String CharacterSound;
    private String sleepPower;
    private String mood;
    private Location location;

    public Person(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
    public Condition getCondition() {
        return condition;
    }
    public String getCharacterSound() {return CharacterSound;}
    public String getSleepPower() {return sleepPower;}
    public String getMood() {
        return mood;
    }
    public String getRocketKnowledge(){return rocketKnowledge;}
    public Location getLocation(){return location;}

    public void setCondition(Condition condition, SleepPower sleepPower){
        this.condition = condition;
        this.CharacterSound = "храпит";
        this.sleepPower = sleepPower.getDescription();
    }

    public void setCondition(Condition condition){
        this.condition = condition;
        this.CharacterSound = "храпит";
        this.sleepPower = "НЕИЗВЕСТНО";
    }

    public void setMood(String mood){
        this.mood = mood;
    }
    public void setRocketKnowledge(String rocketKnowledge){this.rocketKnowledge = rocketKnowledge;}
    public void setLocation(Location location){this.location = location;}
    //public void setPlace(Place place){this.place = place;}

    @Override
    public int hashCode() {
        return super.hashCode() + this.getName().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj.hashCode() == this.hashCode();
    }

    @Override
    public String toString() {
        return this.getName();
    }
}

