package exceptions;

public class NoManaException extends RuntimeException {
    public NoManaException(String referencedBy) {
        super("EXCEPTION: " + referencedBy + " does not have enough mana to cast a spell!");
    }
}
