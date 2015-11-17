package lv.javaguru.java3.core.services.user.exception;


public class UserNotFoundException extends Exception {
      public UserNotFoundException() {
        super("User not found");
    }
}
