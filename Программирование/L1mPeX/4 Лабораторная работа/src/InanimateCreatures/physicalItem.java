package InanimateCreatures;

import Creatures.Personage;
import Interfaces.OnItem;

public record physicalItem (String name) implements OnItem {
    @Override
    public void beHanged(Room.Walls where) {
        System.out.println(String.format("%s повесили %s", this.name, where));
    }

    @Override
    public void beRemoved(Room.Walls fromWhere) {
        System.out.println(String.format("%s сняли с %s", this.name, fromWhere));
    }

    @Override
    public void beWashed(Personage obj) {
        System.out.println(String.format("%s помыл %s", obj.getName(), this.name));
    }

    @Override
    public void writeDown(String byWhat) {
        System.out.println(String.format("%s записали: %s", this.name, byWhat));
    }

    @Override
    public String toString() {
        return String.format("Предмет %s", this.name);
    }
}
