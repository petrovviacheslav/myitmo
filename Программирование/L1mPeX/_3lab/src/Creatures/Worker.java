package Creatures;

import InanimateCreatures.Book;
import InanimateCreatures.Services;
import Interfaces.Followable;
import Interfaces.Talkable;

public class Worker extends Character {
    private final String name = "Работник";
    public Worker(String name) {
        super(name);
    }

    public void follow(Character byWho) {
        Followable.followBy(this, byWho);
    }

    public void follow(Dog byWho) {
        Followable.followBy(this, byWho);
    }

    public void say(String what) {
        Talkable.say(what);
    }

    public void setTax (Character forWho, Services forWhat, int howMuch) {
        System.out.println("Назначил долг " + howMuch + " денег за " + forWhat + " для " + forWho.getName());
    }

    public void write(String what, Book book) {
        book.addText(what);
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
        return "Персонаж " + this.getName();
    }
}
