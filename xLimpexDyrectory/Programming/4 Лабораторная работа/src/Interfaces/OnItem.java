package Interfaces;

import Creatures.Personage;
import InanimateCreatures.Room;

public interface OnItem {
    void beHanged(Room.Walls where);

    void beRemoved(Room.Walls fromWhere);

    void beWashed(Personage who);

    void writeDown(String byWhat);
}
