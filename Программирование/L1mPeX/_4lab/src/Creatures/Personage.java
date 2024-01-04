package Creatures;

import Interfaces.Followable;
import Interfaces.Strokeable;
import Interfaces.Talkable;
import Exceptions.MethodNotAllowed;
import Interfaces.Washable;

public abstract class Personage implements Followable, Talkable, Washable, Strokeable {
    private String name;
    public Personage(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public void putDown(Object obj) {
        System.out.println(String.format("%s положил %s", this.name, obj));
    }

    public void sit() {
        System.out.println(String.format("%s сел", this.name));
    }

    @Override
    public void stroke(Personage who) {
        System.out.println(String.format("%s потер %s", this.name, who.getName()));
    }

    @Override
    public void followBy(Personage byWho) {
        System.out.println(String.format("%s следует с %s", this.name, byWho.getName()));
    }

    @Override
    public void say(String message) throws MethodNotAllowed { // Исключение будет использоваться в классе, что наследуется от данного
        System.out.println(String.format("%s сказал %s", this.name, message));
    }

    @Override
    public void wash(Personage who) throws MethodNotAllowed { // Исключение будет использоваться в классе, что наследуется от данного
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
        return character.name.equals(name);
    }

    @Override
    public String toString() {
        return String.format("Персонаж %s", this.name);
    }
}
