package lv.javaguru.java3.core.commands.mail.message;

import lv.javaguru.java3.core.dto.mail.message.MessageCountDTO;
import org.springframework.stereotype.Component;

import static lv.javaguru.java3.core.dto.mail.message.MessageCountDTOBuilder.createMessageCountDTO;

/**
 * Created by Andrew on 02.12.2015.
 */
@Component
public class MessageCountConverter {

    public MessageCountDTO convert(int messageCount) {
        return createMessageCountDTO()
                .withMessageCount(messageCount)
                .build();
    }

}
