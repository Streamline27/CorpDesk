package lv.javaguru.java3.rest.gallery;

import lv.javaguru.java3.core.dto.gallerycluster.GalleryDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * Created by Aleksej_home on 2016.01.02..
 */
public interface GalleryResource {



    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/gallery/{id}")
    Response get(@PathParam("id")Long id) throws Exception;

    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/gallery/{id}/index")
    Response getIndex(@PathParam("id")Long id, @QueryParam("page") Integer page) throws Exception;

    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/gallery")
    Response getAll() throws Exception;

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/gallery")
    Response create(GalleryDTO galleryDTO) throws Exception;

    @PUT
    @Path("/gallery/{id}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    Response update(@PathParam("id")Long id, GalleryDTO galleryDTO) throws Exception;

    @DELETE
    @Path("/gallery/{id}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    Response delete(@PathParam("id")Long id) throws Exception;
}
