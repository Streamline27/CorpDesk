package lv.javaguru.java3.core.commands.mail.message;

import lv.javaguru.java3.core.domain.mail.Message;
import lv.javaguru.java3.core.domain.mail.Recipient;
import lv.javaguru.java3.core.domain.user.User;
import lv.javaguru.java3.core.dto.mail.message.MessageDTO;
import lv.javaguru.java3.core.dto.mail.message.MessageHeaderDTO;
import lv.javaguru.java3.core.services.mail.message.MessageService;
import lv.javaguru.java3.core.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static lv.javaguru.java3.core.dto.mail.message.MessageDTOBuilder.createMessageDTO;
import static lv.javaguru.java3.core.dto.mail.message.MessageHeaderDTOBuilder.createMessageHeaderDTO;

/**
 * Created by Andrew on 01.12.2015.
 */
@Component
public class MessageConverter {

    @Autowired private UserService userService;
    @Autowired private MessageService messageService;

    public MessageDTO convert(Message message) {
        return createMessageDTO()
                .withId(message.getId())
                .withSender(message.getSender())
                .withTitle(message.getTitle())
                .withBody(message.getBody())
                .withCreated(message.getCreated())
                .withRecipients(extractUsers(message.getRecipients()))
                .build();
    }

    public List<MessageHeaderDTO> convert(List<Recipient> recipientList) {

        List<MessageHeaderDTO> headerDTOList = new ArrayList<>();

        for (Recipient recipient : recipientList) {

            Message message = messageService.get(recipient.getMessageId());

            headerDTOList.add(createMessageHeaderDTO()
                    .withMessageId(recipient.getMessageId())
                    .withTitle(message.getTitle())
                    .withSender(message.getSender())
                    .withCreated(message.getCreated())
                    .build());
        }

        return headerDTOList;
    }

    private List<User> extractUsers(List<Recipient> recipients) {
        List<User> users = new ArrayList<>();
        for (Recipient recipient : recipients)
            users.add(userService.get(recipient.getUserId()));
        return users;
    }

}
