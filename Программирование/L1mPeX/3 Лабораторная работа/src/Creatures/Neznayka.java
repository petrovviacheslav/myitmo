package Creatures;

import Creatures.*;
import Interfaces.Followable;
import java.util.Objects;

public class Neznayka extends Character {
    private int balance = 0;
    private String name;
    public Neznayka(String name) {
        super(name);
        this.name = name;
    }

    public void sit() {
        System.out.println(String.format("%s сел",this.name));
    }

    public void stroke(Dog forWho) {
        forWho.stroked(this);
    }

    public void pay(Worker forWho, int howMuch) {
        System.out.println(this.name + " заплатил " + forWho.getName() + " " + howMuch + " денег");
    }

    public void getSalary() {
        System.out.println(this.name + " получил зарплату");
    }

    public boolean canPay(int howMuch) {
        return (balance >= howMuch);
    }

    public void goAway() {
        System.out.println(this.name + " ушел");
    }

    public void follow(Character byWho) {
        Followable.followBy(this, byWho);
    }

    public void follow(Dog byWho) {
        Followable.followBy(this, byWho);
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

        Neznayka character = (Neznayka) obj;
        return character.name.equals(this.name);
    }

    @Override
    public String toString() {
        return "Персонаж " + this.getName();
    }
}
