package Interfaces;

import Exceptions.MethodNotAllowed;

public interface Talkable {
    void say(String message) throws MethodNotAllowed;
}
