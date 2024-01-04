package Interfaces;

import Creatures.*;

public interface Strokeable {

    static void beStroked(Neznayka byWho, Dog who) {
        System.out.println(who.toString() + " был поглажен " + byWho.toString());
    }
}
