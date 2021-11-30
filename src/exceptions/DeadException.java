package exceptions;

public class DeadException extends RuntimeException {
    public DeadException(String referencedBy) {
        super("EXCEPTION: " + referencedBy + " is dead, so " + referencedBy + "cannot do anything!");
    }

}
