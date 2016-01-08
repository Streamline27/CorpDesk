package lv.javaguru.java3.rest.gallery;

import com.google.gson.Gson;
import lv.javaguru.java3.core.commands.gallerycluster.gallery.*;
import lv.javaguru.java3.core.dto.gallerycluster.GalleryDTO;

import static lv.javaguru.java3.core.dto.gallerycluster.GalleryDTOBuilder.aGalleryDTO;
import lv.javaguru.java3.core.services.CommandExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * Created by Aleksej_home on 2016.01.02..
 */
@RestController
@Path("/gallerycluster/gallery")
public class GalleryResourceImpl implements GalleryResource {

    private CommandExecutor commandExecutor;
    private Gson gson;

    @Autowired
    public GalleryResourceImpl(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
        this.gson = new Gson();
    }

  /* @Override
   @GET
   @Consumes(APPLICATION_JSON)
   @Produces(APPLICATION_JSON)
   public Response getCurrent(@QueryParam("galleryId") Long galleryId) throws Exception {
       try {

           //  GetGalleryCommand command = new GetGalleryCommand(userId); // TODO logged in user?
           GetGalleryCommand command = new GetGalleryCommand(9l); // TODO logged in user?
           GetGalleryResult result = commandExecutor.execute(command);

           return Response.ok().entity(gson.toJson(result.getGalleryDTO())).build();


       } catch (Exception e) {
           return Response.serverError().entity(gson.toJson(e.getMessage())).build();
       }
   }*/

    @Override
    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response getAll() throws Exception {
        try {
            GetAllGalleryCommand command = new GetAllGalleryCommand();
            GetAllGalleryResult result = commandExecutor.execute(command);
            return Response.ok().entity(gson.toJson(result.getAllGalleryDTOs())).build();

        } catch (Exception e) {
            return Response.serverError().entity(gson.toJson(e.getMessage())).build();
        }
    }
    @Override
    @GET
    @Path("/{id}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response get(@PathParam("id")Long id) throws Exception {
        try {
            GetGalleryCommand command = new GetGalleryCommand(id); // TODO logged in user?
            GetGalleryResult result = commandExecutor.execute(command);
            return Response.ok().entity(gson.toJson(result.getGalleryDTO())).build();
        } catch (Exception e) {
            return Response.serverError().entity(gson.toJson(e.getMessage())).build();
        }
    }
    @Override
    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response create(GalleryDTO galleryDTO) throws Exception {
        try {
            GetGalleryCommand command = new GetGalleryCommand(9l); // TODO logged in user?
            GetGalleryResult result = commandExecutor.execute(command);
            return Response.ok().entity(gson.toJson(null)).build();
        } catch (Exception e) {
            return Response.serverError().entity(gson.toJson(e.getMessage())).build();
        }
    }

    @Override
    @PUT
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response update(GalleryDTO galleryDTO) throws Exception {
        try {
            UpdateGalleryCommand command = new UpdateGalleryCommand(galleryDTO); // TODO logged in user?
            UpdateGalleryResult result = commandExecutor.execute(command);
            return Response.ok().entity(gson.toJson(result.getGalleryDTO())).build();
        } catch (Exception e) {
            return Response.serverError().entity(gson.toJson(e.getMessage())).build();
        }
    }

    @Override
    @DELETE
    @Path("/{id}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response delete(@PathParam("id")Long id) throws Exception {
        try {
            DeleteGalleryCommand command = new DeleteGalleryCommand(id); // TODO logged in user?
             commandExecutor.execute(command);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().entity(gson.toJson(e.getMessage())).build();
        }
    }


}
