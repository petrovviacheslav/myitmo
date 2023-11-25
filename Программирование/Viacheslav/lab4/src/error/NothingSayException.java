package error;

import world.Character;

public class NothingSayException extends Exception{
    private Character character;
    private String message;

    public NothingSayException(Character character, String message){
        super(character + message);
        this.character = character;
        this.message = message;
    }

    @Override
    public String getMessage(){
        return "Существо: " + character + message;
    }
}
