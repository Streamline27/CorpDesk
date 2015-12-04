package lv.javaguru.java3.core.services.user.exception;


public class UserAlreadyExistException extends Exception {
      public UserAlreadyExistException() {
        super("User with given login already exist");
    }
}
