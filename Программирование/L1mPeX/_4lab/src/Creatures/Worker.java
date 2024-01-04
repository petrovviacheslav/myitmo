package Creatures;

import InanimateCreatures.Book;
import InanimateCreatures.Services;

public class Worker extends Personage {
    private final String name;
    public Worker(String name) {
        super(name);
        this.name = name;

    }

    public void setTax (Personage forWho, Services forWhat, int howMuch) {
        System.out.println(String.format("%s назначил долг %d денег за %s для %s", this.name, howMuch, forWhat, forWho.getName()));
    }

    public void write(String what, Book book) {
        book.writeDown(what);
    }

    @Override
    public void followBy(Personage byWho) {
        System.out.println(String.format("%s следует с %s", this.name, byWho.getName()));
    }

    @Override
    public void say(String message) {
        System.out.println(String.format("%s сказал %s", this.name, message));
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

        Worker character = (Worker) obj;
        return character.name.equals(this.name);
    }

    @Override
    public String toString() {
        return String.format("Персонаж %s", this.name);
    }
}
