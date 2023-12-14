package human;

public abstract class Person {
    private String name;
    private Condition condition;
    private String CharacterSound;
    private String sleepPower;
    private String mood;

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

    public void setCondition(Condition condition, SleepPower sleepPower){
        this.condition = condition;
        this.CharacterSound = "храпит";
        this.sleepPower = sleepPower.getDescription();
    }
    public void setMood(String mood){
        this.mood = mood;
    }

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

