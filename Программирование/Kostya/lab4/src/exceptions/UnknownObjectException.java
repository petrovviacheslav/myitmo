package exceptions;

public class UnknownObjectException extends RuntimeException{
    public UnknownObjectException(String s){
        System.out.println(s);
    }

    @Override
    public String getMessage() {
        return "НЕЗНАЙКА НЕ МОЖЕТ ВЗАИМОДЕЙСТВОВАТЬ С ОДНИМ ИЗ УКАЗАННЫХ ПРЕДМЕТОВ";
    }
}
