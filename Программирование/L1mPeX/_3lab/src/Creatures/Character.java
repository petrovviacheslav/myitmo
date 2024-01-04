package Creatures;

import Interfaces.Followable;
import Interfaces.Talkable;

abstract class Character implements Followable, Talkable {
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
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }

        Character character = (Character) obj;
        return character.name.equals(name);
    }

    @Override
    public String toString() {
        return "Персонаж " + this.getName();
    }
}
