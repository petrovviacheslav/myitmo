package Interfaces;

import Exceptions.MethodNotAllowed;
import Creatures.*;

public interface Strokeable {
    void stroke(Personage who) throws MethodNotAllowed;
}
