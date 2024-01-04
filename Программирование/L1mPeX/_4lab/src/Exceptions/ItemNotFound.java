package Exceptions;

public class ItemNotFound extends Exception {
    public ItemNotFound(String errorMessage) {
        super(errorMessage);
    }

    public String getCauseOfException() {
        StackTraceElement[] stackTrace = this.getStackTrace();  // Фигня откуда вытягиваем стек вызова функций (загуглил, но понял лишь примерно)
        if (stackTrace != null && stackTrace.length > 0) {
            StackTraceElement firstStackTraceElement = stackTrace[0];
            return firstStackTraceElement.toString(); // Возвращаем первый элемент стека вызова
        }
        return null; // Если стек вызова пустой, то делаем причину ошибку null
    }
}
