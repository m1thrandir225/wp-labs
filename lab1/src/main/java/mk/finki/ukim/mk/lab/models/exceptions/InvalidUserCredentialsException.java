package mk.finki.ukim.mk.lab.models.exceptions;

public class InvalidUserCredentialsException extends RuntimeException {
    public InvalidUserCredentialsException() {
        super("Invalid credentials exception");
    }
}
