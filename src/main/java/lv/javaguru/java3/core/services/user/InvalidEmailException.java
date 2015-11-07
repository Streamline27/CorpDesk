package lv.javaguru.java3.core.services.user;

public class InvalidEmailException extends Exception{
    public InvalidEmailException() {
        super("Invalid Email Address");
    }
}
