package lv.javaguru.java3.core.database.mail.exception;

/**
 * Created by Andrew on 13.11.2015.
 */
public class IllegalOperationException extends Exception{
    public IllegalOperationException(String s) {
        super("Illegal operation - " + s);
    }
}
