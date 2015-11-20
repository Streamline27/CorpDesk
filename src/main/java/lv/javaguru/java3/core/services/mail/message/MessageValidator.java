package lv.javaguru.java3.core.services.mail.message;

import lv.javaguru.java3.core.domain.user.User;

import java.util.List;

/**
 * Created by Andrew on 17.11.2015.
 */
public interface MessageValidator {

    void validate(User sender,
                  String title,
                  String body,
                  List<User> recipients,
                  boolean isImportant);

}
