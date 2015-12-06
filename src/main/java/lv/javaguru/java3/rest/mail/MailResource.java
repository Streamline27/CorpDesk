package lv.javaguru.java3.rest.mail;

import lv.javaguru.java3.core.dto.mail.message.MessageDTO;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * Created by Andrew on 02.12.2015.
 */
public interface MailResource {

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/mail")
    void send(MessageDTO messageDTO) throws Exception;

}
