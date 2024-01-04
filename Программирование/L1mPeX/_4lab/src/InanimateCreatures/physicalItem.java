package InanimateCreatures;

import Interfaces.Hangedable;
import InanimateCreatures.Room;

public record physicalItem (String name) implements Hangedable {

    @Override
    public void beHanged(Room where) {
        System.out.println();
    }

    @Override
    public void beRemoved(Room fromWhere) {
        System.out.println();
    }
    @Override
    public String toString() {
        return String.format("Предмет %s", this.name);
    }
}
