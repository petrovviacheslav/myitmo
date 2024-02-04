package Interfaces;

import Creatures.*;

public interface Followable {
    static void followBy(Object who, Object byWho) {
        System.out.println(who.toString() + " следует за " + byWho.toString());
    }
}
