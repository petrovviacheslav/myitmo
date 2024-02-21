package world.heroes;

import world.heroes.Person;

public class Rabbit extends Person {
    public Rabbit(String name) {
        super(name);
    }
    public void ready(String what){
        System.out.println(this.getName() + " всегда был готов повторять " + what);
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
