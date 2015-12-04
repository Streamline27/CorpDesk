package lv.javaguru.java3.core.dto.mail.message;

import java.io.Serializable;

/**
 * Created by Andrew on 01.12.2015.
 */
public class MessageCountDTO implements Serializable {

    private int messageCount;

    public int getMessageCount() {
        return messageCount;
    }

    public void setMessageCount(int messageCount) {
        this.messageCount = messageCount;
    }
}
