package world.heroes;

import world.heroes.Person;

public class Vinni extends Person {
    public Vinni(String name) {
        super(name);
    }

    public void takePosition(String description) {
        System.out.println(this.getName() + " занял " + description + " позицию");
    }

    public void standUp() {
        System.out.println(this.getName() + " поднялся и начал приходить в себя");
    }

    public void feel(String feelings) {
        System.out.println(this.getName() + " чувствовал, что " + feelings);
    }

    @Override
    public int hashCode() {
        return super.hashCode() + this.getName().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj.hashCode() == this.hashCode();
    }

    @Override
    public String toString() {
        return "персонаж " + this.getName();
    }
}
