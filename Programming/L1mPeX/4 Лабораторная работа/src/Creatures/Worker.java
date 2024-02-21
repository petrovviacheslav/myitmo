package Creatures;

import InanimateCreatures.Services;
import InanimateCreatures.physicalItem;

public class Worker extends Personage {
    private final String name;
    public Worker(String name) {
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

    public void setTax (Personage forWho, Services forWhat, int howMuch) {
        System.out.println(String.format("%s назначил долг %d денег за %s для %s", this.name, howMuch, forWhat.getService(), forWho.getName()));
    }

    public void write(String what, physicalItem book) {
        book.writeDown(what);
    }

    @Override
    public void followBy(Personage byWho) {
        System.out.println(String.format("%s следует с %s", this.name, byWho.getName()));
    }

    @Override
    public void say(String message) {
        System.out.println(String.format("%s сказал: %s", this.name, message));
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
        return String.format("Персонаж %s", this.name);
    }
}
