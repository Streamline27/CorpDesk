package lv.javaguru.java3.core.commands.mail.message.send;

import lv.javaguru.java3.core.commands.DomainCommand;
import lv.javaguru.java3.core.commands.VoidResult;
import lv.javaguru.java3.core.domain.user.User;

import java.util.List;

/**
 * Created by Andrew on 30.11.2015.
 */
public class SendMessageCommand implements DomainCommand<VoidResult>{

    private User sender;
    private String title;
    private String body;
    private boolean isImportant;
    private List<User> recipients;

    public SendMessageCommand(User sender,
                              String title,
                              String body,
                              boolean isImportant,
                              List<User> recipients) {
        this.sender = sender;
        this.title = title;
        this.body = body;
        this.isImportant = isImportant;
        this.recipients = recipients;
    }

    public User getSender() {
        return sender;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public boolean isImportant() {
        return isImportant;
    }

    public List<User> getRecipients() {
        return recipients;
    }

}
