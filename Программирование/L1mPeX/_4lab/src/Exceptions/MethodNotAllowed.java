package Exceptions;

public class MethodNotAllowed extends Exception {
    public MethodNotAllowed(String errorMessage) {
        super(errorMessage);
    }

    public String getCauseOfException() {
        StackTraceElement[] stackTrace = this.getStackTrace();  // Фигня откуда вытягиваем стек вызова функций
        if (stackTrace != null && stackTrace.length > 0) {
            StackTraceElement firstStackTraceElement = stackTrace[0];
            return firstStackTraceElement.toString(); // Возвращаем первый элемент стека вызова
        }
        return null; // Если стек вызова пустой, то делаем причину ошибку null
    }
}