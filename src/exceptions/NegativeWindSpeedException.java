package exceptions;

public class NegativeWindSpeedException extends RuntimeException {
    public NegativeWindSpeedException(String message) {
        super(message);
    }
}
