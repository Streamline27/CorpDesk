package lv.javaguru.java3.core.services.mail.exception;

/**
 * Created by Boss on 29.12.2015.
 */
public class MessageNotFoundException extends Exception {

    public MessageNotFoundException() {
        super("Message not found");
    }
}
