package lesson02.task02;

public class MethodIsNotRealisedException extends Exception{
    public MethodIsNotRealisedException(Throwable e) {
        initCause(e);
    }

    public MethodIsNotRealisedException(String message) {
        super(message);
    }
}
