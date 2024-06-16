package Creatures;

import Exceptions.MethodNotAllowed;

public class Homemade extends Personage {
    private final String name;
    public Homemade(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void putDown(Object obj) {
        System.out.println(String.format("%s положил %s", this.name, obj));
    }

    @Override
    public void sit() {
        System.out.println(String.format("%s сел", this.name));
    }

    @Override
    public void stroke(Personage who) {
        System.out.println(String.format("%s расчесал %s", this.name, who.getName()));
    }

    @Override
    public void followBy(Personage byWho) {
        System.out.println(String.format("%s следует с %s", this.name, byWho.getName()));
    }

    @Override
    public void say(String message) throws MethodNotAllowed {
        System.out.println(String.format("%s сказал: %s", this.name, message));
    }

    @Override
    public void wash(Personage who) throws MethodNotAllowed {
        System.out.println(String.format("%s помыл %s", this.name, who.getName()));
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

        Personage character = (Personage) obj;
        return character.getName().equals(this.name);
    }

    @Override
    public String toString() {
        return "Персонаж " + this.getName();
    }
}
