package Creatures;

import Exceptions.MethodNotAllowed;
import InanimateCreatures.physicalItem;

public class Dog extends Personage {
    private final String name;
    public Dog(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public void sit() {
        System.out.println(String.format("%s сел", this.name));
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void followBy(Personage byWho) {
        System.out.println(String.format("%s следует с %s", this.name, byWho.getName()));
    }

    @Override
    public void wash(Personage who) throws MethodNotAllowed {
        if (who.equals(this)) System.out.println(String.format("%s помылась", this.name));
        else throw new MethodNotAllowed(String.format("%s не может мыть кого-либо, кроме себя", this.name), new IllegalAccessException());
    }

    @Override
    public void stroke(Personage who) {
        System.out.println(String.format("%s потерся об %s", this.name, who.getName()));
    }

    public void stroke(physicalItem what) {
        System.out.println(String.format("%s потерся об %s", this.name, what));
    }

    @Override
    public void say(String what) throws MethodNotAllowed {
        if (!what.equalsIgnoreCase("гав")) throw new MethodNotAllowed(String.format("%s может говорить только \"гав\"", this.name), new IllegalAccessException());
        else System.out.println(String.format("%s гавкнул", this.name));
    }

    @Override
    public int hashCode() {
        return super.hashCode();
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
        return String.format("Собака %s", this.name);
    }
}
