package lv.javaguru.java3.rest.gallery;

import com.google.gson.Gson;
import lv.javaguru.java3.core.commands.gallerycluster.category.*;
import lv.javaguru.java3.core.dto.gallerycluster.CategoryDTO;
import lv.javaguru.java3.core.services.CommandExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * Created by Aleksej_home on 2016.02.14..
 */
@RestController
@Path("/gallery/category")
public class CategoryResourceImpl implements CategoryResource{

    private CommandExecutor commandExecutor;
    private Gson gson;

    @Autowired
    public CategoryResourceImpl(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
        this.gson = new Gson();
    }

    @Override
    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/{id}")
    public Response get(@PathParam("id") Long id) throws Exception {
        try {
            GetCategoryCommand command = new GetCategoryCommand(id); // TODO logged in user?
            GetCategoryResult result = commandExecutor.execute(command);
            return Response.ok().entity(gson.toJson(result.getCategoryDTO())).build();
          /*  if (page == null) page = 1;
            GetCategoryLimitedImagesCommand command = new GetCategoryLimitedImagesCommand(id,page);
            GetCategoryLimitedImagesResult result = commandExecutor.execute(command);
            System.out.println("REGUEST: "+ id);*/
           // return Response.ok().entity(gson.toJson(result.getCategoryDTO())).build();

          //  return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().entity(gson.toJson(e.getMessage())).build();
        }
    }



    @Override
    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/{id}/thumb")
    public Response getThumb(@PathParam("id")Long id, @QueryParam("page") Integer page) throws Exception {
        try {
            if (page == null) page = 1;
            GetCategoryLimitedImagesCommand command = new GetCategoryLimitedImagesCommand(id,page);
            GetCategoryLimitedImagesResult result = commandExecutor.execute(command);
            //System.out.println("REGUEST: "+ id);
            return Response.ok().entity(gson.toJson(result.getCategoryDTO())).build();
        } catch (Exception e) {
            return Response.serverError().entity(gson.toJson(e.getMessage())).build();
        }
    }

    @Override
    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/{id}/middle")
    public Response getMiddle(@PathParam("id")Long id, @QueryParam("page") Integer page) throws Exception {
        try {
            System.out.println("1");
            if (page == null) page = 1;
            GetCategoryImagesSmallPageCommand command = new GetCategoryImagesSmallPageCommand(id,page);
            GetCategoryImagesSmallPageResult result = commandExecutor.execute(command);

            return Response.ok().entity(gson.toJson(result.getCategoryDTO())).build();
        } catch (Exception e) {
            return Response.serverError().entity(gson.toJson(e.getMessage())).build();
        }
    }

    @Override
    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/{id}/orig")
    public Response getOrig(@PathParam("id")Long id, @QueryParam("page") Integer page) throws Exception {
        try {
            if (page == null) page = 1;
            GetCategoryImagesSmallPageCommand command = new GetCategoryImagesSmallPageCommand(id,page);
            GetCategoryImagesSmallPageResult result = commandExecutor.execute(command);
            return Response.ok().entity(gson.toJson(result.getCategoryDTO())).build();
        } catch (Exception e) {
            return Response.serverError().entity(gson.toJson(e.getMessage())).build();
        }
    }

    @Override
    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response getAll() throws Exception {
        try {

          //  GetAllCategoryCommand command = new GetAllCategoryCommand();
          //  GetAllCategoryResult result = commandExecutor.execute(command);
         //   return Response.ok().entity(gson.toJson(result.getAllCategoryDTOs())).build();
             return Response.ok().build();

        } catch (Exception e) {
            return Response.serverError().entity(gson.toJson(e.getMessage())).build();
        }
    }

    @Override
    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response create(CategoryDTO categoryDTO) throws Exception {
        try {
            CreateCategoryCommand command = new CreateCategoryCommand(categoryDTO); // TODO logged in user?
            CreateCategoryResult result = commandExecutor.execute(command);
            return Response.ok().entity(gson.toJson(result.getCategoryDTO())).build();
            // return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().entity(gson.toJson(e.getMessage())).build();
        }
    }

    @Override
    @PUT
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, CategoryDTO categoryDTO) throws Exception {
        try {
            UpdateCategoryCommand command = new UpdateCategoryCommand(categoryDTO); // TODO logged in user?
            UpdateCategoryResult result = commandExecutor.execute(command);

            return Response.ok().entity(gson.toJson(result.getCategoryDTO())).build();
            // return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().entity(gson.toJson(e.getMessage())).build();
        }
    }

    @Override
    @DELETE
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) throws Exception {
        try {
            DeleteCategoryCommand command = new DeleteCategoryCommand(id); // TODO logged in user?
            commandExecutor.execute(command);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().entity(gson.toJson(e.getMessage())).build();
        }
    }
}
