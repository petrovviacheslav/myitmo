package Creatures;

import Exceptions.MethodNotAllowed;

public class Neznayka extends Personage {
    private int balance = 0;
    private String name;
    public Neznayka(String name) {
        super(name);
        this.name = name;
    }

    public void sit() {
        System.out.println(String.format("%s сел", this.name));
    }

    public void pay(Worker forWho, int howMuch) {
        System.out.println(String.format("%s залатил %s %d денег", this.name, forWho.getName(), howMuch));
    }

    public void getSalary() {
        System.out.println(String.format("%s получил зарплату", this.name));
    }

    public boolean canPay(int howMuch) {
        return (balance >= howMuch);
    }

    public void goAway() {
        System.out.println(String.format("%s ушел", this.name));
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
        return String.format("Персонаж %s", this.name);
    }
}
