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

import static lv.javaguru.java3.core.domain.mail.MessageBuilder.createMessage;
import static lv.javaguru.java3.core.domain.user.UserBuilder.createUser;
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
                //.withSender(userService.get(message.getSenderId()))
                .withSender(createUser().withId(message.getSenderId()).build())
                .withTitle(message.getTitle())
                .withBody(message.getBody())
                .withCreated(message.getCreated())
                .isImportant(message.isImportant())
                .withRecipients(extractUsers(message.getRecipients(), message.getSenderId()))
                .build();
    }

    public Message convert(MessageDTO messageDTO) throws Exception {
        return createMessage()
                .withSenderId(messageDTO.getSender().getId())
                .withTitle(messageDTO.getTitle())
                .withBody(messageDTO.getBody())
                .withRecipients(getRecipients(messageDTO.getId()))
                .isImportant(messageDTO.isImportant())
                .build();
    }

    public List<MessageHeaderDTO> convert(List<Recipient> recipientList) throws Exception {

        List<MessageHeaderDTO> headerDTOList = new ArrayList<>();

        for (Recipient recipient : recipientList) {

            Message message = messageService.get(recipient.getMessageId());

            headerDTOList.add(createMessageHeaderDTO()
                    .withMessageId(recipient.getMessageId())
                    .withTitle(message.getTitle())
                            //.withSender(userService.get(message.getSenderId()))
                    .withSender(createUser().withId(message.getSenderId()).build())
                    .withCreated(message.getCreated())
                    .isImportant(message.isImportant())
                    .build());
        }

        return headerDTOList;
    }

    private List<User> extractUsers(List<Recipient> recipients, Long senderUserId) {
        List<User> users = new ArrayList<>();
        for (Recipient recipient : recipients)
            if (recipient.getUserId() != senderUserId)
                users.add(createUser().withId(recipient.getUserId()).build());
                //users.add(userService.get(recipient.getUserId()));
        return users;
    }

    private List<Recipient> getRecipients(Long id) throws Exception {
        return messageService.get(id).getRecipients();
    }

}
