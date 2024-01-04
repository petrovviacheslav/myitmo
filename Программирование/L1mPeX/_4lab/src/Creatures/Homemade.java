package Creatures;

public class Homemade extends Personage {
    private final String name;
    public Homemade(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + this.name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }

        Homemade character = (Homemade) obj;
        return character.name.equals(this.name);
    }

    @Override
    public String toString() {
        return "Персонаж " + this.getName();
    }
}
