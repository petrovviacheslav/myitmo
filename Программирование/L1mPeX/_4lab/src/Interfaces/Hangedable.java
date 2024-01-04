package Interfaces;

import InanimateCreatures.Room;

// Сюда можно и Cratures подключить. По логическим ссуждениям, это сделать надо, но по нормам морали этого делать не надо

public interface Hangedable {
    void beHanged(Room where);

    void beRemoved(Room fromWhere);
}
