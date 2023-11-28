package world.heroes;

import actions.SeverityLevel;
import world.UnderstandingLevel;

public class Piglet extends Person {
    public Piglet(String name) {
        super(name);
    }
    public void nod(SeverityLevel level) {
        System.out.println(this.getName() + level.getLevel() + " кивал в ответ");
    }
    public void understand(UnderstandingLevel level) {
        System.out.println(this.getName() + " показывает, что он " + level.getLevel() + " понимает");
    }

    public void push(Person person) {
        System.out.println(this.getName() + " толкнул " + person);
    }

    public void settle() {
        System.out.println(this.getName() + " уладил дело");
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
