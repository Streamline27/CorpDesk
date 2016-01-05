package lv.javaguru.java3.core.services.mail.exception;


public class DestinationFolderNotFoundException extends Exception{

    public DestinationFolderNotFoundException() {
        super("Destination folder not found");
    }
}
