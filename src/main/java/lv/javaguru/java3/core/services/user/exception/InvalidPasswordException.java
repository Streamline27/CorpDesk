package lv.javaguru.java3.core.services.user.exception;

public class InvalidPasswordException extends Exception {
    public InvalidPasswordException() {
        super("Incorrect password!");
    }
}
