package exceptions;

public class UnknownLocationException extends RuntimeException{
    public UnknownLocationException(String message){
        super(message);
    }

    @Override
    public String getMessage() {
        return "НЕВОЗМОЖНО ПЕРЕМЕСТИТЬ ПЕРСОНАЖА В ЛОКАЦИЮ";
    }
}
