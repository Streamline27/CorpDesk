package lv.javaguru.java3.rest.mail;

import com.google.gson.Gson;
import lv.javaguru.java3.core.commands.mail.message.count.GetMessageCountCommand;
import lv.javaguru.java3.core.commands.mail.message.count.GetMessageCountResult;
import lv.javaguru.java3.core.commands.mail.message.count_unread.GetUnreadMessageCountCommand;
import lv.javaguru.java3.core.commands.mail.message.count_unread.GetUnreadMessageCountResult;
import lv.javaguru.java3.core.commands.mail.message.delete.DeleteMessageCommand;
import lv.javaguru.java3.core.commands.mail.message.get.GetMessageCommand;
import lv.javaguru.java3.core.commands.mail.message.get.GetMessageResult;
import lv.javaguru.java3.core.commands.mail.message.list.ListMessagesCommand;
import lv.javaguru.java3.core.commands.mail.message.list.ListMessagesResult;
import lv.javaguru.java3.core.commands.mail.message.move.MoveToFolderCommand;
import lv.javaguru.java3.core.commands.mail.message.send.SendMessageCommand;
import lv.javaguru.java3.core.dto.mail.message.MessageDTO;
import lv.javaguru.java3.core.services.CommandExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * Created by Andrew on 02.12.2015.
 */
@Component
@Path("/mail/message")
public class MailResourceImpl implements MailResource {

    private CommandExecutor commandExecutor;
    private Gson gson;

    @Autowired
    public MailResourceImpl(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
        this.gson = new Gson();
    }

    @Override
    @GET
    @Path("/count")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response count(@QueryParam("folderId") long folderId) throws Exception {
        try {
            GetMessageCountCommand command = new GetMessageCountCommand(folderId); // TODO logged in user?
            GetMessageCountResult result = commandExecutor.execute(command);
            return Response.ok().entity(gson.toJson(result.getMessageCountDTO())).build();
        } catch (Exception e) {
            return Response.serverError().entity(gson.toJson(e.getMessage())).build();
        }
    }

    @Override
    @GET
    @Path("/count/unread")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response countUnread(@QueryParam("folderId") long folderId) throws Exception {
        try {
            GetUnreadMessageCountCommand command = new GetUnreadMessageCountCommand(folderId); // TODO logged in user?
            GetUnreadMessageCountResult result = commandExecutor.execute(command);
            return Response.ok().entity(gson.toJson(result.getMessageCountDTO())).build();
        } catch (Exception e) {
            return Response.serverError().entity(gson.toJson(e.getMessage())).build();
        }
    }

    @Override
    @DELETE
    //@Path("/")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response deleteMessage(@QueryParam("messageId") long messageId) throws Exception {
        try {
            DeleteMessageCommand command = new DeleteMessageCommand(getLoggedInUserId(), messageId);
            commandExecutor.execute(command);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().entity(gson.toJson(e.getMessage())).build();
        }
    }

    @Override
    @GET
    //@Path("/")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response getMessage(@QueryParam("messageId") long messageId) throws Exception {
        try {
            GetMessageCommand command = new GetMessageCommand(messageId); // TODO logged in user?
            GetMessageResult result = commandExecutor.execute(command);
            return Response.ok().entity(gson.toJson(result.getMessageDTO())).build();
        } catch (Exception e) {
            return Response.serverError().entity(gson.toJson(e.getMessage())).build();
        }
    }

    @Override
    @GET
    @Path("/list")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response listMessages(@QueryParam("folderId") long folderId) throws Exception {
        try {
            ListMessagesCommand command = new ListMessagesCommand(folderId); // TODO logged in user?
            ListMessagesResult result = commandExecutor.execute(command);
            return Response.ok().entity(gson.toJson(result.getMessageHeadersDTO())).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().entity(gson.toJson(e.getMessage())).build();
        }
    }

    @Override
    @GET
    @Path("/move")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response moveMessage(@QueryParam("messageId") long messageId,
                                @QueryParam("folderId") long folderId) throws Exception {
        try {
            MoveToFolderCommand command = new MoveToFolderCommand(messageId, getLoggedInUserId(), folderId);
            commandExecutor.execute(command);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().entity(gson.toJson(e.getMessage())).build();
        }
    }

    @Override
    @Path("/send")
    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response send(MessageDTO messageDTO) throws Exception {
        try {
            SendMessageCommand command = new SendMessageCommand(
                     messageDTO.getSender(),
                     messageDTO.getTitle(),
                     messageDTO.getBody(),
                     messageDTO.isImportant(),
                     messageDTO.getRecipients());
            commandExecutor.execute(command);
            return Response.ok().build();
        } catch (Exception e){
            e.printStackTrace();
            return Response.serverError().entity(gson.toJson(e.getMessage())).build();
        }

    }

    private long getLoggedInUserId() {
        return 1L; // TODO getLoggedInUserId
    }


}
