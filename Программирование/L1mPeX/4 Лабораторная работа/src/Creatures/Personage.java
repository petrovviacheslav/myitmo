package Creatures;

import Exceptions.MethodNotAllowed;
import Interfaces.PersonageTo;

public abstract class Personage implements PersonageTo {
    private String name;
    public Personage(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    abstract public void sit();
    @Override
    public void putDown(Object obj) {}

    @Override
    public void stroke(Personage who) {}

    @Override
    public void followBy(Personage byWho) {}

    @Override
    public void say(String message) throws MethodNotAllowed {}

    @Override
    public void wash(Personage who) throws MethodNotAllowed {}

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
        return character.getName().equals(name);
    }

    @Override
    public String toString() {
        return String.format("Персонаж %s", this.name);
    }
}
