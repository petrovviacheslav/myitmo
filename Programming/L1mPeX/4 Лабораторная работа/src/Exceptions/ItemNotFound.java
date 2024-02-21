package Exceptions;

public class ItemNotFound extends Exception {
    private String errorMessage;
    public ItemNotFound(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
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
    public String getMessage() {
        return this.errorMessage;
    }
}
