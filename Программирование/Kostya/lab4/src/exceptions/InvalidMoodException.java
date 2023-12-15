package exceptions;

public class InvalidMoodException extends Exception{
    public InvalidMoodException(String message){
        super(message);
    }

    @Override
    public String getMessage() {
        return "НЕВОЗМОЖНО ОПРЕДЕЛИТЬ НАСКОЛЬКО ЕДА РАДОВАЛА ПЕРСОНАЖА";
    }
}
