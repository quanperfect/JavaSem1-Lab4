package exceptions;

public class NegativeCloudIntensity extends RuntimeException {
    public NegativeCloudIntensity(String message) {
        super(message);
    }
}
