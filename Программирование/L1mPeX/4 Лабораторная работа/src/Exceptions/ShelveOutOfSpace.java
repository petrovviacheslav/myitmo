package Exceptions;

// ArrayIndexOutOfBoundsException в Java является unchecked исключением,
// так что это исключение было сделано таким же из сообращений логики/их сходства
public class ShelveOutOfSpace extends RuntimeException {
    public ShelveOutOfSpace(String errorMessage) {
        super(errorMessage);
    }

    public String getCauseOfException() {
        StackTraceElement[] stackTrace = this.getStackTrace();  // Фигня откуда вытягиваем стек вызова функций
        if (stackTrace != null && stackTrace.length > 0) {
            StackTraceElement firstStackTraceElement = stackTrace[0];
            return firstStackTraceElement.toString(); // Возвращаем первый элемент стека вызова, т.е. то что выполнялось последним
        }
        return null; // Если стек вызова пустой, то делаем причину ошибку null
    }
}
