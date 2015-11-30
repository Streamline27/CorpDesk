package lv.javaguru.java3.core.services.mail.exception;

/**
 * Created by Andrew on 21.11.2015.
 */
public class FolderNotEmptyException extends Exception{
    public FolderNotEmptyException() {
        super("Folder not empty");
    }
}
