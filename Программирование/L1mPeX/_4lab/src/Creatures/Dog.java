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
    public void wash(Personage who) throws MethodNotAllowed {
        if (who.equals(this)) System.out.println(String.format("%s помылась", this.name));
        else throw new MethodNotAllowed(String.format("%s не может мыть кого-либо, кроме себя", this.name));
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
        if (!what.equalsIgnoreCase("гав")) throw new MethodNotAllowed(String.format("%s может говорить только \"гав\"", this.name));
        else System.out.println(String.format("%s гавкнул", this.name));
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj;
    }

    @Override
    public String toString() {
        return String.format("Собака %s", this.name);
    }

}
