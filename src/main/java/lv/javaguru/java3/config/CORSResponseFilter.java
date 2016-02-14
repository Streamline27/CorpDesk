package lv.javaguru.java3.config;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

@Provider
@PreMatching
public class CORSResponseFilter
        implements ContainerResponseFilter {

    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
            throws IOException {

        MultivaluedMap<String, Object> headers = responseContext.getHeaders();

        headers.add( "Access-Control-Allow-Origin", "*" );
        headers.add( "Access-Control-Allow-Credentials", "true" );
        headers.add( "Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS" );
        headers.add( "Access-Control-Allow-Headers", "Cache-Control, Pragma, Origin, Authorization, Content-Type, X-Requested-With" );
    }

}