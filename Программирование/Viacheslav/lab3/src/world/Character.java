package world;
import actions.*;
public abstract class Character implements Talkable {
    private String name;
    public Character(String name) {
        this.name = name;
    }
    public String getName() {
        return name == null ? "..." : name;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + this.getName().hashCode();
    }

    @Override
    public boolean equals(Object ob) {
        if (ob == this) {
            return true;
        }

        if (ob == null || ob.getClass() != getClass()) {
            return false;
        }

        Character character = (Character) ob;
        return character.name.equals(name);


    }

    @Override
    public String toString() {
        return "существо " + this.getName();
    }
}