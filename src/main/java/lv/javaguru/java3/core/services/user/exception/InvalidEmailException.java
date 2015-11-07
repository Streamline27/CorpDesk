package lv.javaguru.java3.core.services.user.exception;

public class InvalidEmailException extends Exception{
    public InvalidEmailException() {
        super("Invalid Email Address");
    }
}
