package actions;
import error.NothingSayException;
import world.Character;

public interface Talkable {
    public void say(Speech type, String message, Character toCharacter, SeverityLevel level) throws NothingSayException;
    public void say(Speech type, String message, SeverityLevel level) throws NothingSayException;
    public void noSay();
}
