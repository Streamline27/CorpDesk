package lv.javaguru.java3.core.services.mail.message.exception;

/**
 * Created by Andrew on 20.11.2015.
 */
public class MessageRecipientNotFoundException extends Exception{
    public MessageRecipientNotFoundException() {
        super("Message recipient not found");
    }
}
