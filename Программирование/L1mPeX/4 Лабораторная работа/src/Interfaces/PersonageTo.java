package Interfaces;

import Creatures.Personage;
import Exceptions.MethodNotAllowed;

public interface PersonageTo {
    void followBy(Personage byWho);

    void stroke(Personage who) throws MethodNotAllowed;

    void say(String message) throws MethodNotAllowed;

    void wash(Personage obj) throws MethodNotAllowed;
    public void putDown(Object obj);

}
