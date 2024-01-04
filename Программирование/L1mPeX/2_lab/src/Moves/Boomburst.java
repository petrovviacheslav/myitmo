package Moves;

import ru.ifmo.se.pokemon.*;

public class Boomburst extends PhysicalMove {
    public Boomburst() {
        super(Type.NORMAL, 140, 100);
    }

    @Override
    protected String describe() {
        return " использует атаку Boomburst: наносит 140 урона";
    }
}