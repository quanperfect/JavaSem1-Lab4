package exceptions;

public class NegativeDamageException extends RuntimeException {
    public NegativeDamageException(String message) {
        super(message);
    }
}
