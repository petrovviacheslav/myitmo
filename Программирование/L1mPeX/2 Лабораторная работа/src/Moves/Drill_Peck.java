package Moves;

import ru.ifmo.se.pokemon.*;

public class Drill_Peck extends PhysicalMove {
    public Drill_Peck() {
        super(Type.FLYING, 80, 100);
    }

    @Override
    protected String describe() {
        return " использует Drill Peck: наносит 80 урона";
    }
}