package actions;
import world.Character;

public interface Talkable {
    public void say(Speech type, String message, Character toCharacter, SeverityLevel level);
    public void say();
}
