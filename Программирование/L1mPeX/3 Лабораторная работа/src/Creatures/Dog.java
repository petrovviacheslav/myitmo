package Creatures;

import Creatures.*;
import Interfaces.Strokeable;

public class Dog implements Strokeable {
    private Character byWho;
    private final String name;

    public Dog(String name) {
        this.name = name;
    }

    public void bark() {
        System.out.println("Гав");
    }

    public void stroked(Neznayka byWho) {
        Strokeable.beStroked(byWho, this);
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
        return "Собака " + this.name;
    }

}
