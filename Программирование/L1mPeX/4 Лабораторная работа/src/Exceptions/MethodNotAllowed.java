package Exceptions;

public class MethodNotAllowed extends Exception {
    private String errorMessage;
    private Throwable cause;

    public MethodNotAllowed(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
        this.errorMessage = errorMessage;
        this.cause = cause;
    }

    public String getCauseOfException() {
        String returnedAnswer = "";
        StackTraceElement[] stackTrace = this.getStackTrace();  // Фигня откуда вытягиваем стек вызова функций
        if (stackTrace != null && stackTrace.length > 0) {
            returnedAnswer = String.format("Стркоа выдавшая ошибку: %s\nВыдача исключения в коде метода: %s", stackTrace[1], stackTrace[0]);
            return returnedAnswer;
        }
        return null; // Если стек вызова пустой, то делаем причину ошибку null
    }


    @Override
    public Throwable getCause() {
        return cause;
    }

    @Override
    public String getMessage() {
        return this.errorMessage;
    }
}