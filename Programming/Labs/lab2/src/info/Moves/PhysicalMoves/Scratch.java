package info.Moves.PhysicalMoves;
import ru.ifmo.se.pokemon.*;

public class Scratch extends PhysicalMove {
    public Scratch(){
        super(Type.NORMAL,40, 100);
    }

    // одно из самых распространенных и базовых движений,
    // которым обучается покемон. Он наносит урон без каких-либо дополнительных эффектов.


    @Override
    protected String describe(){
        return "использует Scratch";
    }
}
