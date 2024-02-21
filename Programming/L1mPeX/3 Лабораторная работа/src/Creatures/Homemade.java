package Creatures;

import Creatures.*;
import Interfaces.Followable;

public class Homemade extends Character {
    private final String name;
    public Homemade(String name) {
        super(name);
        this.name = name;
    }

    public void follow(Character byWho) {
        Followable.followBy(this, byWho);
        System.out.println(this.name + " сопровождает " + byWho.getName());
    }

    public void follow(Dog byWho) {
        Followable.followBy(this, byWho);
        System.out.println(this.name + " сопровождает собаку");
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
