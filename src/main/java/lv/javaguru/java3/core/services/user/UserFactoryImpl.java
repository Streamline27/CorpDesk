package lv.javaguru.java3.core.services.user;

import lv.javaguru.java3.core.database.user.UserDAO;
import lv.javaguru.java3.core.domain.user.User;
import lv.javaguru.java3.core.domain.user.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static lv.javaguru.java3.core.domain.user.UserBuilder.createUser;

@Component
class UserFactoryImpl implements UserFactory {

    @Autowired private UserValidator userValidator;
    @Autowired private UserDAO userDAO;

    @Override
    public User create(String login, String password, Role userRole, String firstName, String lastName, String email) throws Exception {
        userValidator.validate(login, password, userRole, firstName, lastName, email);
        User user = createUser().withLogin(login)
                .withPassword(password)
                .withUserRole(userRole)
                .withFirstName(firstName)
                .withLastName(lastName)
                .withEmail(email).build();
        userDAO.create(user);
        return user;
    }
}
