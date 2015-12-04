package lv.javaguru.java3.core.services.mail.exception;

/**
 * Created by Andrew on 02.12.2015.
 */
public class InvalidFolderOperationException extends Exception {

    public InvalidFolderOperationException() {
        super("Non-custom folders can not be deleted");
    }
}
