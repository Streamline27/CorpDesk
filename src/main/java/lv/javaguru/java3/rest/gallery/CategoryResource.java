package lv.javaguru.java3.rest.gallery;

import lv.javaguru.java3.core.dto.gallerycluster.CategoryDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * Created by Aleksej_home on 2016.02.14..
 */
public interface CategoryResource {


    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/gallerycluster/category/{id}")
    Response get(@PathParam("id")Long id) throws Exception;

    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/gallerycluster/category")
    Response getAll() throws Exception;

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/gallerycluster/category")
    Response create(CategoryDTO categoryDTO) throws Exception;

    @PUT
    @Path("/gallerycluster/category/{id}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    Response update(@PathParam("id")Long id, CategoryDTO categoryDTO) throws Exception;

    @DELETE
    @Path("/gallerycluster/category/{id}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    Response delete(@PathParam("id")Long id) throws Exception;
}
