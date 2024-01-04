package Exceptions;

// ArrayIndexOutOfBoundsException в Java является unchecked исключением,
// так что это исключение было сделано таким же из сообращений логики/их сходства
public class ShleveNotFound extends RuntimeException {
    public ShleveNotFound(String errorMessage) {
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
