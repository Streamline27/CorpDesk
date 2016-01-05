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
    @Path("/gallerycluster/gallery/{id}")
    Response get(@PathParam("id")Long id) throws Exception;

    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/gallerycluster/gallery")
    Response getAll() throws Exception;

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/gallerycluster/gallery")
    Response create(GalleryDTO galleryDTO) throws Exception;

    @PUT
    @Path("/gallerycluster/gallery")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response update(GalleryDTO galleryDTO) throws Exception;

    @DELETE
    @Path("/gallerycluster/gallery/{id}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response delete(@PathParam("id")Long id) throws Exception;
}
