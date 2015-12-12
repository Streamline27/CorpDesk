package lv.javaguru.java3.rest.mail;

import lv.javaguru.java3.core.dto.mail.message.MessageDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * Created by Andrew on 02.12.2015.
 */
public interface MailResource {

    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/mail/count")
    Response count(@QueryParam("folderId") long folderId) throws Exception;

    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/mail/count/unread")
    Response countUnread(@QueryParam("folderId") long folderId) throws Exception;

    @DELETE
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/mail/message")
    Response deleteMessage(@QueryParam("messageId") long messageId) throws Exception;

    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/mail/message")
    Response getMessage(@QueryParam("messageId") long messageId) throws Exception;

    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/mail/messages/list")
    Response listMessages(@QueryParam("folderId") long folderId) throws Exception;

    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/mail/message/move")
    Response moveMessage(@QueryParam("messageId") long messageId,
                         @QueryParam("folderId") long folderId) throws Exception;

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/mail/send")
    Response send(MessageDTO messageDTO) throws Exception;

}
