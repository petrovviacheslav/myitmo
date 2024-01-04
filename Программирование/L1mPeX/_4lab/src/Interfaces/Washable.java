package Interfaces;

import Creatures.Personage;
import Exceptions.MethodNotAllowed;

public interface Washable {
    void wash(Personage obj) throws MethodNotAllowed;
}
