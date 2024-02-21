package world;
import actions.*;
import error.NameException;

public abstract class Character implements Talkable {
    private String name;
    public Character(String name) throws NameException {
        this.name = name;
        if(name.isEmpty())
            throw new NameException("Объект не может быть создан без имени!");
    }
    public String getName() {
        return name == null ? "..." : name;
    }

    @Override
    public void noSay() {
        if (Math.random() < 0.5)
            System.out.println(this.getName() + " ничего не говорит");
        else
            System.out.println(this.getName() + " молчит");
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