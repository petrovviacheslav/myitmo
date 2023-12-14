package activity;

import human.Person;
import room.InterectingObject;

public interface Interactionable {
    void toInteract(Person person, InterectingObject[] args);
}
