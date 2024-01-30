package Moves;

import ru.ifmo.se.pokemon.*;

public class Drill_Run extends PhysicalMove {
    public Drill_Run() {
        super(Type.GROUND, 80, 95);
    }

    @Override
    protected String describe() {
        return " использует Drill Run: наносит 80 урона";
    }
}
